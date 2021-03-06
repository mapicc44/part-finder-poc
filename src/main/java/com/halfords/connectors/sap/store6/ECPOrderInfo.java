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
 * <p>Java class for ECPOrderInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ECPOrderInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CustomerOrderNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PurchaseOrderLineNo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="PurchaseOrderNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PurchaseOrderStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="VendorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ECPOrderInfo", propOrder = {
    "customerOrderNo",
    "purchaseOrderLineNo",
    "purchaseOrderNo",
    "purchaseOrderStatus",
    "vendorCode"
})
public class ECPOrderInfo {

    @XmlElementRef(name = "CustomerOrderNo", namespace = "http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> customerOrderNo;
    @XmlElement(name = "PurchaseOrderLineNo")
    protected Integer purchaseOrderLineNo;
    @XmlElementRef(name = "PurchaseOrderNo", namespace = "http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> purchaseOrderNo;
    @XmlElementRef(name = "PurchaseOrderStatus", namespace = "http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> purchaseOrderStatus;
    @XmlElementRef(name = "VendorCode", namespace = "http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> vendorCode;

    /**
     * Gets the value of the customerOrderNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerOrderNo() {
        return customerOrderNo;
    }

    /**
     * Sets the value of the customerOrderNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerOrderNo(JAXBElement<String> value) {
        this.customerOrderNo = value;
    }

    /**
     * Gets the value of the purchaseOrderLineNo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPurchaseOrderLineNo() {
        return purchaseOrderLineNo;
    }

    /**
     * Sets the value of the purchaseOrderLineNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPurchaseOrderLineNo(Integer value) {
        this.purchaseOrderLineNo = value;
    }

    /**
     * Gets the value of the purchaseOrderNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    /**
     * Sets the value of the purchaseOrderNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPurchaseOrderNo(JAXBElement<String> value) {
        this.purchaseOrderNo = value;
    }

    /**
     * Gets the value of the purchaseOrderStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPurchaseOrderStatus() {
        return purchaseOrderStatus;
    }

    /**
     * Sets the value of the purchaseOrderStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPurchaseOrderStatus(JAXBElement<String> value) {
        this.purchaseOrderStatus = value;
    }

    /**
     * Gets the value of the vendorCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVendorCode() {
        return vendorCode;
    }

    /**
     * Sets the value of the vendorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVendorCode(JAXBElement<String> value) {
        this.vendorCode = value;
    }

}
