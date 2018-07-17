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
 * <p>Java class for FaultDetailDataContract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaultDetailDataContract"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CorrelationUniqueId" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/&gt;
 *         &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ErrorTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExceptionDetail" type="{http://schemas.datacontract.org/2004/07/System.ServiceModel}ExceptionDetail" minOccurs="0"/&gt;
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ServiceAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaultDetailDataContract", namespace = "http://www.epicor.com/Retail/Store/", propOrder = {
    "correlationUniqueId",
    "errorCode",
    "errorTypeCode",
    "exceptionDetail",
    "message",
    "serviceAddress"
})
public class FaultDetailDataContract {

    @XmlElement(name = "CorrelationUniqueId")
    protected String correlationUniqueId;
    @XmlElement(name = "ErrorCode")
    protected Integer errorCode;
    @XmlElementRef(name = "ErrorTypeCode", namespace = "http://www.epicor.com/Retail/Store/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errorTypeCode;
    @XmlElementRef(name = "ExceptionDetail", namespace = "http://www.epicor.com/Retail/Store/", type = JAXBElement.class, required = false)
    protected JAXBElement<ExceptionDetail> exceptionDetail;
    @XmlElementRef(name = "Message", namespace = "http://www.epicor.com/Retail/Store/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> message;
    @XmlElementRef(name = "ServiceAddress", namespace = "http://www.epicor.com/Retail/Store/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceAddress;

    /**
     * Gets the value of the correlationUniqueId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationUniqueId() {
        return correlationUniqueId;
    }

    /**
     * Sets the value of the correlationUniqueId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationUniqueId(String value) {
        this.correlationUniqueId = value;
    }

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setErrorCode(Integer value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the errorTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrorTypeCode() {
        return errorTypeCode;
    }

    /**
     * Sets the value of the errorTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrorTypeCode(JAXBElement<String> value) {
        this.errorTypeCode = value;
    }

    /**
     * Gets the value of the exceptionDetail property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ExceptionDetail }{@code >}
     *     
     */
    public JAXBElement<ExceptionDetail> getExceptionDetail() {
        return exceptionDetail;
    }

    /**
     * Sets the value of the exceptionDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ExceptionDetail }{@code >}
     *     
     */
    public void setExceptionDetail(JAXBElement<ExceptionDetail> value) {
        this.exceptionDetail = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessage(JAXBElement<String> value) {
        this.message = value;
    }

    /**
     * Gets the value of the serviceAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getServiceAddress() {
        return serviceAddress;
    }

    /**
     * Sets the value of the serviceAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setServiceAddress(JAXBElement<String> value) {
        this.serviceAddress = value;
    }

}