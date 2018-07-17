/**
 * DT_Request_RTStock_Item.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package com.halfords.xi.out.ecommerce.st;

public class DT_Request_RTStock_Item  implements java.io.Serializable {
    private java.lang.String site;
    private java.lang.String article;
    private java.lang.String DC;
    private java.lang.String store1;
    private java.lang.String store2;
    private java.lang.String store3;
    private java.lang.String store4;
    private java.lang.String store5;

    public DT_Request_RTStock_Item() {
    }

    public DT_Request_RTStock_Item(
           java.lang.String site,
           java.lang.String article,
           java.lang.String DC,
           java.lang.String store1,
           java.lang.String store2,
           java.lang.String store3,
           java.lang.String store4,
           java.lang.String store5) {
           this.site = site;
           this.article = article;
           this.DC = DC;
           this.store1 = store1;
           this.store2 = store2;
           this.store3 = store3;
           this.store4 = store4;
           this.store5 = store5;
    }


    /**
     * Gets the site value for this DT_Request_RTStock_Item.
     * 
     * @return site
     */
    public java.lang.String getSite() {
        return site;
    }


    /**
     * Sets the site value for this DT_Request_RTStock_Item.
     * 
     * @param site
     */
    public void setSite(java.lang.String site) {
        this.site = site;
    }


    /**
     * Gets the article value for this DT_Request_RTStock_Item.
     * 
     * @return article
     */
    public java.lang.String getArticle() {
        return article;
    }


    /**
     * Sets the article value for this DT_Request_RTStock_Item.
     * 
     * @param article
     */
    public void setArticle(java.lang.String article) {
        this.article = article;
    }


    /**
     * Gets the DC value for this DT_Request_RTStock_Item.
     * 
     * @return DC
     */
    public java.lang.String getDC() {
        return DC;
    }


    /**
     * Sets the DC value for this DT_Request_RTStock_Item.
     * 
     * @param DC
     */
    public void setDC(java.lang.String DC) {
        this.DC = DC;
    }


    /**
     * Gets the store1 value for this DT_Request_RTStock_Item.
     * 
     * @return store1
     */
    public java.lang.String getStore1() {
        return store1;
    }


    /**
     * Sets the store1 value for this DT_Request_RTStock_Item.
     * 
     * @param store1
     */
    public void setStore1(java.lang.String store1) {
        this.store1 = store1;
    }


    /**
     * Gets the store2 value for this DT_Request_RTStock_Item.
     * 
     * @return store2
     */
    public java.lang.String getStore2() {
        return store2;
    }


    /**
     * Sets the store2 value for this DT_Request_RTStock_Item.
     * 
     * @param store2
     */
    public void setStore2(java.lang.String store2) {
        this.store2 = store2;
    }


    /**
     * Gets the store3 value for this DT_Request_RTStock_Item.
     * 
     * @return store3
     */
    public java.lang.String getStore3() {
        return store3;
    }


    /**
     * Sets the store3 value for this DT_Request_RTStock_Item.
     * 
     * @param store3
     */
    public void setStore3(java.lang.String store3) {
        this.store3 = store3;
    }


    /**
     * Gets the store4 value for this DT_Request_RTStock_Item.
     * 
     * @return store4
     */
    public java.lang.String getStore4() {
        return store4;
    }


    /**
     * Sets the store4 value for this DT_Request_RTStock_Item.
     * 
     * @param store4
     */
    public void setStore4(java.lang.String store4) {
        this.store4 = store4;
    }


    /**
     * Gets the store5 value for this DT_Request_RTStock_Item.
     * 
     * @return store5
     */
    public java.lang.String getStore5() {
        return store5;
    }


    /**
     * Sets the store5 value for this DT_Request_RTStock_Item.
     * 
     * @param store5
     */
    public void setStore5(java.lang.String store5) {
        this.store5 = store5;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof DT_Request_RTStock_Item)) return false;
        DT_Request_RTStock_Item other = (DT_Request_RTStock_Item) obj;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.site==null && other.getSite()==null) || 
             (this.site!=null &&
              this.site.equals(other.getSite()))) &&
            ((this.article==null && other.getArticle()==null) || 
             (this.article!=null &&
              this.article.equals(other.getArticle()))) &&
            ((this.DC==null && other.getDC()==null) || 
             (this.DC!=null &&
              this.DC.equals(other.getDC()))) &&
            ((this.store1==null && other.getStore1()==null) || 
             (this.store1!=null &&
              this.store1.equals(other.getStore1()))) &&
            ((this.store2==null && other.getStore2()==null) || 
             (this.store2!=null &&
              this.store2.equals(other.getStore2()))) &&
            ((this.store3==null && other.getStore3()==null) || 
             (this.store3!=null &&
              this.store3.equals(other.getStore3()))) &&
            ((this.store4==null && other.getStore4()==null) || 
             (this.store4!=null &&
              this.store4.equals(other.getStore4()))) &&
            ((this.store5==null && other.getStore5()==null) || 
             (this.store5!=null &&
              this.store5.equals(other.getStore5())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getSite() != null) {
            _hashCode += getSite().hashCode();
        }
        if (getArticle() != null) {
            _hashCode += getArticle().hashCode();
        }
        if (getDC() != null) {
            _hashCode += getDC().hashCode();
        }
        if (getStore1() != null) {
            _hashCode += getStore1().hashCode();
        }
        if (getStore2() != null) {
            _hashCode += getStore2().hashCode();
        }
        if (getStore3() != null) {
            _hashCode += getStore3().hashCode();
        }
        if (getStore4() != null) {
            _hashCode += getStore4().hashCode();
        }
        if (getStore5() != null) {
            _hashCode += getStore5().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DT_Request_RTStock_Item.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://halfords.com/xi/out/ecommerce/st", "DT_Request_RTStock_Item"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("site");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Site"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("article");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Article"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("store1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Store1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("store2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Store2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("store3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Store3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("store4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Store4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("store5");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Store5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
