//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.23 at 06:41:17 PM BST 
//


package com.halfords.connectors.sap.store6;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FitmentInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FitmentInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Engine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Make" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Year" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FitmentInfo", propOrder = {
    "engine",
    "make",
    "model",
    "year"
})
public class FitmentInfo {

    @XmlElementRef(name = "Engine", namespace = "http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> engine;
    @XmlElementRef(name = "Make", namespace = "http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> make;
    @XmlElementRef(name = "Model", namespace = "http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> model;
    @XmlElementRef(name = "Year", namespace = "http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> year;

    /**
     * Gets the value of the engine property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEngine() {
        return engine;
    }

    /**
     * Sets the value of the engine property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEngine(JAXBElement<String> value) {
        this.engine = value;
    }

    /**
     * Gets the value of the make property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMake() {
        return make;
    }

    /**
     * Sets the value of the make property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMake(JAXBElement<String> value) {
        this.make = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setModel(JAXBElement<String> value) {
        this.model = value;
    }

    /**
     * Gets the value of the year property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setYear(JAXBElement<String> value) {
        this.year = value;
    }

}
