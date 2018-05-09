//
//This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
//See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
//Any modifications to this file will be lost upon recompilation of the source schema. 
//Generated on: 2014.11.04 at 08:53:58 PM EST 
//


package com.avaya.grt.service.iposs.ipoInventory91;

import javax.xml.bind.annotation.XmlRegistry;
import com.avaya.grt.service.iposs.ipoInventory91.Response.Data;
import com.avaya.grt.service.iposs.ipoInventory91.Response.Data.Inventory;
import com.avaya.grt.service.iposs.ipoInventory91.Response.Data.Inventory.Hardware;
import com.avaya.grt.service.iposs.ipoInventory91.Response.Data.Inventory.Hardware.Modules;
import com.avaya.grt.service.iposs.ipoInventory91.Response.Data.Inventory.Hardware.Modules.Module;
import com.avaya.grt.service.iposs.ipoInventory91.Response.Data.Inventory.Hardware.SDCard;
import com.avaya.grt.service.iposs.ipoInventory91.Response.Data.Inventory.Hardware.Units;
import com.avaya.grt.service.iposs.ipoInventory91.Response.Data.Inventory.Hardware.Units.Unit;
import com.avaya.grt.service.iposs.ipoInventory91.Response.Data.Inventory.IdentityCertificates;
import com.avaya.grt.service.iposs.ipoInventory91.Response.Data.Inventory.IdentityCertificates.IdentityCertificate;
import com.avaya.grt.service.iposs.ipoInventory91.Response.Data.Inventory.Licenses;
import com.avaya.grt.service.iposs.ipoInventory91.Response.Data.Inventory.Licenses.License;
import com.avaya.grt.service.iposs.ipoInventory91.Response.Data.Inventory.Software;
import com.avaya.grt.service.iposs.ipoInventory91.Response.Data.Inventory.Software.Component;
import com.avaya.grt.service.iposs.ipoInventory91.Response.Data.Inventory.SystemConfigSummary;


/**
* This object contains factory methods for each 
* Java content interface and Java element interface 
* generated in the com.grt.ipoInventory91 package. 
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


 /**
  * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.grt.ipoInventory91
  * 
  */
 public ObjectFactory() {
 }

 /**
  * Create an instance of {@link SDCard }
  * 
  */
 public SDCard createResponseDataInventoryHardwareSDCard() {
     return new SDCard();
 }

 /**
  * Create an instance of {@link SystemConfigSummary }
  * 
  */
 public SystemConfigSummary createResponseDataInventorySystemConfigSummary() {
     return new SystemConfigSummary();
 }

 /**
  * Create an instance of {@link Inventory }
  * 
  */
 public Inventory createResponseDataInventory() {
     return new Inventory();
 }

 /**
  * Create an instance of {@link Data }
  * 
  */
 public Data createResponseData() {
     return new Data();
 }

 /**
  * Create an instance of {@link Hardware }
  * 
  */
 public Hardware createResponseDataInventoryHardware() {
     return new Hardware();
 }

 /**
  * Create an instance of {@link Response }
  * 
  */
 public Response createResponse() {
     return new Response();
 }

 /**
  * Create an instance of {@link Modules }
  * 
  */
 public Modules createResponseDataInventoryHardwareModules() {
     return new Modules();
 }

 /**
  * Create an instance of {@link Component }
  * 
  */
 public Component createResponseDataInventorySoftwareComponent() {
     return new Component();
 }

 /**
  * Create an instance of {@link Unit }
  * 
  */
 public Unit createResponseDataInventoryHardwareUnitsUnit() {
     return new Unit();
 }

 /**
  * Create an instance of {@link IdentityCertificates }
  * 
  */
 public IdentityCertificates createResponseDataInventoryIdentityCertificates() {
     return new IdentityCertificates();
 }

 /**
  * Create an instance of {@link Software }
  * 
  */
 public Software createResponseDataInventorySoftware() {
     return new Software();
 }

 /**
  * Create an instance of {@link Units }
  * 
  */
 public Units createResponseDataInventoryHardwareUnits() {
     return new Units();
 }

 /**
  * Create an instance of {@link HeaderType }
  * 
  */
 public HeaderType createHeaderType() {
     return new HeaderType();
 }

 /**
  * Create an instance of {@link Licenses }
  * 
  */
 public Licenses createResponseDataInventoryLicenses() {
     return new Licenses();
 }

 /**
  * Create an instance of {@link IdentityCertificate }
  * 
  */
 public IdentityCertificate createResponseDataInventoryIdentityCertificatesIdentityCertificate() {
     return new IdentityCertificate();
 }

 /**
  * Create an instance of {@link License }
  * 
  */
 public License createResponseDataInventoryLicensesLicense() {
     return new License();
 }

 /**
  * Create an instance of {@link Module }
  * 
  */
 public Module createResponseDataInventoryHardwareModulesModule() {
     return new Module();
 }

}
