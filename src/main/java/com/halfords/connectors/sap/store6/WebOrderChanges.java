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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="order" type="{http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts}WebOrderChange" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "order"
})
@XmlRootElement(name = "WebOrderChanges", namespace = "http://HAL.BTEIntegration.Order.Service")
public class WebOrderChanges {

    @XmlElementRef(name = "order", namespace = "http://HAL.BTEIntegration.Order.Service", type = JAXBElement.class, required = false)
    protected JAXBElement<WebOrderChange> order;

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WebOrderChange }{@code >}
     *     
     */
    public JAXBElement<WebOrderChange> getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WebOrderChange }{@code >}
     *     
     */
    public void setOrder(JAXBElement<WebOrderChange> value) {
        this.order = value;
    }

}
