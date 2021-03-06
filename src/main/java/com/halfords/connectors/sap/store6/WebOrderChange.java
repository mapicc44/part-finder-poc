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
 * <p>Java class for WebOrderChange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WebOrderChange"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ArticleDetails" type="{http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts}ArrayOfArticleDetails" minOccurs="0"/&gt;
 *         &lt;element name="OrderNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "WebOrderChange", propOrder = {
    "articleDetails",
    "orderNo",
    "orderType",
    "storeNo"
})
public class WebOrderChange {

    @XmlElementRef(name = "ArticleDetails", namespace = "http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfArticleDetails> articleDetails;
    @XmlElementRef(name = "OrderNo", namespace = "http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orderNo;
    @XmlElementRef(name = "OrderType", namespace = "http://schemas.datacontract.org/2004/07/HAL.Web.Order.Contracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orderType;
    @XmlElement(name = "StoreNo")
    protected Integer storeNo;

    /**
     * Gets the value of the articleDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfArticleDetails }{@code >}
     *     
     */
    public JAXBElement<ArrayOfArticleDetails> getArticleDetails() {
        return articleDetails;
    }

    /**
     * Sets the value of the articleDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfArticleDetails }{@code >}
     *     
     */
    public void setArticleDetails(JAXBElement<ArrayOfArticleDetails> value) {
        this.articleDetails = value;
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
     * Gets the value of the orderType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderType() {
        return orderType;
    }

    /**
     * Sets the value of the orderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderType(JAXBElement<String> value) {
        this.orderType = value;
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
