package com.grt.integration.jms;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NameNotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.avaya.grt.jms.fmw.xml.filePoller.jms.IBaseCreateRespType;
import com.avaya.grt.service.TechnicalRegistrationUtil;
import com.avaya.grt.service.installbase.InstallBaseJMSService;
import com.grt.dto.InstallBaseSapResponseDto;

public class JmsFilePollerListener extends BaseJmsListener implements MessageListener{
	
	private static final Logger logger = Logger.getLogger(JmsFilePollerListener.class);
	private String principal;
	private String credential;
	private Context ctx = null;
	private String systemIdentifier;
	private String jmsxDeliveryCount = "1";
	private InstallBaseJMSService installBaseJMSService;
	private TechnicalRegistrationUtil technicalRegistrationUtil = new TechnicalRegistrationUtil();
	
	static {
        logger.debug("From Static block of JmsFilePollerListener");
    }
	
	@SuppressWarnings("unchecked")
	public void onMessage(Message message) {
		logger.debug("inside onMessage");
        if(message == null) {
            String errMsg = "Received NULL message from JMS. Cannot continue.";
            logger.error(errMsg);
        } else if(!(message instanceof TextMessage)) {
            String errMsg = "Received invalid message - not a type of TextMessage. Cannot continue.";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        } else {
        	jmsxDeliveryCount = printCustomJMSHeaders(message, logger);
            String textMsg = null;
            String txtTransactionId = null;
            String txtErrorId= null;
            try {
                textMsg = ((TextMessage)message).getText();
                txtTransactionId = message.getStringProperty("TRANSACTION_ID");
                txtErrorId = message.getStringProperty("ERROR_ID");
                
                if (textMsg == null || textMsg.equals("")) {
                    String errMsg = "Received NULL or EMPTY text message from JMS. Cannot continue.";
                    logger.error(errMsg);
                    throw new Exception(errMsg);
                }
                logger.debug("Received text message from JMS: \n" + textMsg);                
                logger.debug("Received Header TransactionId, After trimming SystemIdentifier:" + txtTransactionId);             
                logger.debug("Received Header Error Id from JMS:" + txtErrorId);
                
                IBaseCreateRespType msgFilePoller = parseXMLJms(textMsg);         
                InstallBaseSapResponseDto installBaseDto = technicalRegistrationUtil.populateServiceRequestDto(msgFilePoller, txtTransactionId, txtErrorId);
                installBaseJMSService.processReceivedInstallBase(installBaseDto);
            } catch(NameNotFoundException nameNotFoundException) {
                logger.error("TRACKER[ ID:" + txtTransactionId + ":DeliveryCount:" + jmsxDeliveryCount +":NameNotFoundException]", nameNotFoundException);
                throw new RuntimeException(nameNotFoundException);
            } catch(JAXBException jaxbe) {
                logger.error("TRACKER[ ID:" + txtTransactionId + ":DeliveryCount:" + jmsxDeliveryCount +":JAXBException]", jaxbe);
                throw new RuntimeException(jaxbe);
            } catch (SecurityException  securityException) {
                logger.error("TRACKER[ ID:" + txtTransactionId  + ":DeliveryCount:" + jmsxDeliveryCount +":SecurityException:" + this.principal + "/" + this.credential + ":" + securityException.getMessage() + "]", securityException);
                throw new RuntimeException(securityException);
            } catch (AuthenticationException authenticationException) {
            	logger.error("TRACKER[ ID:" + txtTransactionId + ":DeliveryCount:" + jmsxDeliveryCount +":AuthenticationException:" + this.principal + "/" + this.credential + ":" + authenticationException.getMessage() + "]", authenticationException);
                throw new RuntimeException(authenticationException);
            } catch (Throwable throwable) {
                logger.error("TRACKER[ ID:" + txtTransactionId  + ":DeliveryCount:" + jmsxDeliveryCount +":" + throwable.getMessage() + "]", throwable);
            } finally  {
            	logger.debug("MESSAGE PROCESSED FOR ID:" + txtTransactionId);
            	if(ctx != null) {
            		try {
            			ctx.close();
            		} catch(Throwable throwable){
            			logger.warn("Error while closing the Context", throwable);
            		}
            	}
            	logger.debug("Completed OnMessage");
            }
        }
    }
	
	@SuppressWarnings("unchecked")
	private IBaseCreateRespType parseXMLJms(String jmsMessage) throws JAXBException {
      logger.debug("Parsing incoming message into IBase Creation Request ...");
		ByteArrayInputStream xmlContentBytes = 
              new ByteArrayInputStream(jmsMessage.getBytes());
		ClassLoader classLoader = 
              com.avaya.grt.jms.fmw.xml.filePoller.jms.ObjectFactory.class.getClassLoader();
		JAXBContext jaxbContext = 
              JAXBContext.newInstance("com.avaya.grt.jms.fmw.xml.filePoller.jms", classLoader);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		unmarshaller.setSchema(null);
		JAXBElement<IBaseCreateRespType> iBaseMessageObj = 
              (JAXBElement<IBaseCreateRespType>) unmarshaller.unmarshal(xmlContentBytes);
		IBaseCreateRespType iBaseRespMessage = iBaseMessageObj.getValue();
	    logger.debug("Completed.");
		return iBaseRespMessage;
	}
	
	public static void main(String[] args) throws Exception {		
		//ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");	
		//TechRegJMSService techRegJMSService = (TechRegJMSService) context.getBean("techRegJMSService");
		
		JmsFilePollerListener obj = new JmsFilePollerListener();
		
		BufferedReader br = null;
		StringBuffer strBuf = new StringBuffer(); 
		try {
			
			final InputStream inputStream = JmsFilePollerListener.class.getResourceAsStream("/IB.xml");
            final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while (bufferedReader.ready()) {
            	strBuf.append(bufferedReader.readLine());
            }
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		String textMsg = strBuf.toString();		
		IBaseCreateRespType result = obj.parseXMLJms(textMsg); 
		System.out.println("Transaction Id : " + result.getIBaseheader().getRegId());
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getSystemIdentifier() {
		return systemIdentifier;
	}

	public void setSystemIdentifier(String systemIdentifier) {
		this.systemIdentifier = systemIdentifier;
	}

	public String getJmsxDeliveryCount() {
		return jmsxDeliveryCount;
	}

	public void setJmsxDeliveryCount(String jmsxDeliveryCount) {
		this.jmsxDeliveryCount = jmsxDeliveryCount;
	}

	public InstallBaseJMSService getInstallBaseJMSService() {
		return installBaseJMSService;
	}

	public void setInstallBaseJMSService(
			InstallBaseJMSService installBaseJMSService) {
		this.installBaseJMSService = installBaseJMSService;
	}
}