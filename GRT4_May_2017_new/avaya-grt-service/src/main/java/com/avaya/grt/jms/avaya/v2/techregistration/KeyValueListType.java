//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.13 at 11:47:56 AM IST 
//


package com.avaya.grt.jms.avaya.v2.techregistration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TechRegResponseListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TechRegResponseListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RegInput" type="{http://avaya.com/v2/techregistration}TechRegDataType"/>
 *         &lt;element name="RegOutput" type="{http://avaya.com/v2/techregistration}OutputType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Parameters", propOrder = {
    "entryKey"
})
public class KeyValueListType {

    @XmlElement(name = "Param")
    protected EntryKey entryKey;

	public EntryKey getEntryKey() {
		return entryKey;
	}

	public void setEntryKey(EntryKey entryKey) {
		this.entryKey = entryKey;
	}

   

}