//
//This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b26-ea3 
//See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
//Any modifications to this file will be lost upon recompilation of the source schema. 
//Generated on: 2012.03.26 at 04:14:18 PM EDT 
//


package com.avaya.grt.service.iposs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.avaya.grt.service.iposs.HeaderType;


/**
* <p>Java class for headerType complex type.
* 
* <p>The following schema fragment specifies the expected content contained within this class.
* 
* <pre>
* &lt;complexType name="headerType">
*   &lt;complexContent>
*     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
*       &lt;sequence>
*         &lt;element name="definition" type="{http://www.w3.org/2001/XMLSchema}string"/>
*         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
*       &lt;/sequence>
*     &lt;/restriction>
*   &lt;/complexContent>
* &lt;/complexType>
* </pre>
* 
* 
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "headerType", propOrder = {
 "definition",
 "version"
})
public class HeaderType {

 protected String definition;
 protected String version;

 /**
  * Gets the value of the definition property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getDefinition() {
     return definition;
 }

 /**
  * Sets the value of the definition property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setDefinition(String value) {
     this.definition = value;
 }

 /**
  * Gets the value of the version property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getVersion() {
     return version;
 }

 /**
  * Sets the value of the version property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setVersion(String value) {
     this.version = value;
 }

}

