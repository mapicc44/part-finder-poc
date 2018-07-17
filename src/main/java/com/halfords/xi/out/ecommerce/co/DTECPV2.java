//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.23 at 06:41:18 PM BST 
//


package com.halfords.xi.out.ecommerce.co;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DT_ECP_V2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DT_ECP_V2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ECPPart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RRPPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CostPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BrandPartNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BrandPartDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Brand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Make" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Year" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Engine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PartTypeNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DT_ECP_V2", propOrder = {
    "ecpPart",
    "rrpPrice",
    "costPrice",
    "brandPartNumber",
    "brandPartDescription",
    "brand",
    "make",
    "model",
    "year",
    "engine",
    "partTypeNumber"
})
public class DTECPV2 {

    @XmlElement(name = "ECPPart")
    protected String ecpPart;
    @XmlElement(name = "RRPPrice")
    protected String rrpPrice;
    @XmlElement(name = "CostPrice")
    protected String costPrice;
    @XmlElement(name = "BrandPartNumber")
    protected String brandPartNumber;
    @XmlElement(name = "BrandPartDescription")
    protected String brandPartDescription;
    @XmlElement(name = "Brand")
    protected String brand;
    @XmlElement(name = "Make")
    protected String make;
    @XmlElement(name = "Model")
    protected String model;
    @XmlElement(name = "Year")
    protected String year;
    @XmlElement(name = "Engine")
    protected String engine;
    @XmlElement(name = "PartTypeNumber")
    protected String partTypeNumber;

    /**
     * Gets the value of the ecpPart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECPPart() {
        return ecpPart;
    }

    /**
     * Sets the value of the ecpPart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECPPart(String value) {
        this.ecpPart = value;
    }

    /**
     * Gets the value of the rrpPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRRPPrice() {
        return rrpPrice;
    }

    /**
     * Sets the value of the rrpPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRRPPrice(String value) {
        this.rrpPrice = value;
    }

    /**
     * Gets the value of the costPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCostPrice() {
        return costPrice;
    }

    /**
     * Sets the value of the costPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCostPrice(String value) {
        this.costPrice = value;
    }

    /**
     * Gets the value of the brandPartNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrandPartNumber() {
        return brandPartNumber;
    }

    /**
     * Sets the value of the brandPartNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrandPartNumber(String value) {
        this.brandPartNumber = value;
    }

    /**
     * Gets the value of the brandPartDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrandPartDescription() {
        return brandPartDescription;
    }

    /**
     * Sets the value of the brandPartDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrandPartDescription(String value) {
        this.brandPartDescription = value;
    }

    /**
     * Gets the value of the brand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the value of the brand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrand(String value) {
        this.brand = value;
    }

    /**
     * Gets the value of the make property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets the value of the make property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMake(String value) {
        this.make = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * Gets the value of the year property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYear(String value) {
        this.year = value;
    }

    /**
     * Gets the value of the engine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEngine() {
        return engine;
    }

    /**
     * Sets the value of the engine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEngine(String value) {
        this.engine = value;
    }

    /**
     * Gets the value of the partTypeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartTypeNumber() {
        return partTypeNumber;
    }

    /**
     * Sets the value of the partTypeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartTypeNumber(String value) {
        this.partTypeNumber = value;
    }

}
