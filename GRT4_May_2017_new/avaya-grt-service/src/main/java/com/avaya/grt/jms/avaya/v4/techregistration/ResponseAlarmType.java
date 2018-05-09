//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.13 at 11:47:56 AM IST 
//


package com.avaya.grt.jms.avaya.v4.techregistration;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransactionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SystemId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TechRegResponseList" type="{http://avaya.com/v2/techregistration}TechRegResponseListType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TechRegAlarmRequest", propOrder = {    
    "techRegResponseAlarmList"
})
public class ResponseAlarmType {
    @XmlElement(name = "TechRegRequestAlarmList", required = true, namespace = "http://avaya.com/v4/techregistration")
    protected List<TechRegResponseAlarmListType> techRegResponseAlarmList;


    /**
     * Gets the value of the techRegResponseList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the techRegResponseList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTechRegResponseList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TechRegResponseListType }
     * 
     * 
     */
    public List<TechRegResponseAlarmListType> getTechRegResponseAlarmList() {
        if (techRegResponseAlarmList == null) {
        	techRegResponseAlarmList = new ArrayList<TechRegResponseAlarmListType>();
        }
        return this.techRegResponseAlarmList;
    }

	public void setTechRegResponseAlarmList(
			List<TechRegResponseAlarmListType> techRegResponseAlarmList) {
		this.techRegResponseAlarmList = techRegResponseAlarmList;
	}

}