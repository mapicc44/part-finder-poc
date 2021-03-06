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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WebOrder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WebOrder"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CustomerDetails" type="{http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts}Customer" minOccurs="0"/&gt;
 *         &lt;element name="CustomerNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ItemDetails" type="{http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts}ArrayOfItem" minOccurs="0"/&gt;
 *         &lt;element name="OrderDetails" type="{http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts}Order" minOccurs="0"/&gt;
 *         &lt;element name="OrderNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StoreNo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WebOrder", propOrder = {
    "customerDetails",
    "customerNo",
    "itemDetails",
    "orderDetails",
    "orderNo",
    "storeNo"
})
public class WebOrder {

    @XmlElementRef(name = "CustomerDetails", namespace = "http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts", type = JAXBElement.class, required = false)
    protected JAXBElement<Customer> customerDetails;
    @XmlElementRef(name = "CustomerNo", namespace = "http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> customerNo;
    @XmlElementRef(name = "ItemDetails", namespace = "http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfItem> itemDetails;
    @XmlElementRef(name = "OrderDetails", namespace = "http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts", type = JAXBElement.class, required = false)
    protected JAXBElement<Order> orderDetails;
    @XmlElementRef(name = "OrderNo", namespace = "http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orderNo;
    @XmlElement(name = "StoreNo")
    protected Integer storeNo;

    /**
     * Gets the value of the customerDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Customer }{@code >}
     *     
     */
    public JAXBElement<Customer> getCustomerDetails() {
        return customerDetails;
    }

    /**
     * Sets the value of the customerDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Customer }{@code >}
     *     
     */
    public void setCustomerDetails(JAXBElement<Customer> value) {
        this.customerDetails = value;
    }

    /**
     * Gets the value of the customerNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerNo() {
        return customerNo;
    }

    /**
     * Sets the value of the customerNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerNo(JAXBElement<String> value) {
        this.customerNo = value;
    }

    /**
     * Gets the value of the itemDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfItem }{@code >}
     *     
     */
    public JAXBElement<ArrayOfItem> getItemDetails() {
        return itemDetails;
    }

    /**
     * Sets the value of the itemDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfItem }{@code >}
     *     
     */
    public void setItemDetails(JAXBElement<ArrayOfItem> value) {
        this.itemDetails = value;
    }

    /**
     * Gets the value of the orderDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Order }{@code >}
     *     
     */
    public JAXBElement<Order> getOrderDetails() {
        return orderDetails;
    }

    /**
     * Sets the value of the orderDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Order }{@code >}
     *     
     */
    public void setOrderDetails(JAXBElement<Order> value) {
        this.orderDetails = value;
    }

    /**
     * Gets the value of the orderNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderNo() {
        return orderNo;
    }

    /**
     * Sets the value of the orderNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderNo(JAXBElement<String> value) {
        this.orderNo = value;
    }

    /**
     * Gets the value of the storeNo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStoreNo() {
        return storeNo;
    }

    /**
     * Sets the value of the storeNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStoreNo(Integer value) {
        this.storeNo = value;
    }

}
