//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.10.15 at 01:24:55 PM CST 
//


package com.avaya.grt.jms.siebel.xml.service20request_2.jms;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.avaya.jms.service.request package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SiebelMessage_QNAME = new QName("http://www.siebel.com/xml/AVAYA%20Service%20Request%20-%20JMS", "SiebelMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.avaya.jms.service.request
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SiebelMessage }
     * 
     */
    public SiebelMessage createSiebelMessage() {
        return new SiebelMessage();
    }

    /**
     * Create an instance of {@link ListOfAvayaServiceRequestJms }
     * 
     */
    public ListOfAvayaServiceRequestJms createListOfAvayaServiceRequestJms() {
        return new ListOfAvayaServiceRequestJms();
    }

    /**
     * Create an instance of {@link ServiceRequest }
     * 
     */
    public ServiceRequest createServiceRequest() {
        return new ServiceRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SiebelMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.siebel.com/xml/AVAYA%20Service%20Request%20-%20JMS", name = "SiebelMessage")
    public JAXBElement<SiebelMessage> createSiebelMessage(SiebelMessage value) {
        return new JAXBElement<SiebelMessage>(_SiebelMessage_QNAME, SiebelMessage.class, null, value);
    }

}