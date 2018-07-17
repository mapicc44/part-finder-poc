/**
 * DT_Request_RTStock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package com.halfords.xi.out.ecommerce.st;

public class DT_Request_RTStock  implements java.io.Serializable {
    private com.halfords.xi.out.ecommerce.st.DT_Request_RTStock_Item[] item;

    public DT_Request_RTStock() {
    }

    public DT_Request_RTStock(
           com.halfords.xi.out.ecommerce.st.DT_Request_RTStock_Item[] item) {
           this.item = item;
    }


    /**
     * Gets the item value for this DT_Request_RTStock.
     * 
     * @return item
     */
    public com.halfords.xi.out.ecommerce.st.DT_Request_RTStock_Item[] getItem() {
        return item;
    }


    /**
     * Sets the item value for this DT_Request_RTStock.
     * 
     * @param item
     */
    public void setItem(com.halfords.xi.out.ecommerce.st.DT_Request_RTStock_Item[] item) {
        this.item = item;
    }

    public com.halfords.xi.out.ecommerce.st.DT_Request_RTStock_Item getItem(int i) {
        return this.item[i];
    }

    public void setItem(int i, com.halfords.xi.out.ecommerce.st.DT_Request_RTStock_Item _value) {
        this.item[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof DT_Request_RTStock)) return false;
        DT_Request_RTStock other = (DT_Request_RTStock) obj;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.item==null && other.getItem()==null) || 
             (this.item!=null &&
              java.util.Arrays.equals(this.item, other.getItem())));
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
        if (getItem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItem(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DT_Request_RTStock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://halfords.com/xi/out/ecommerce/st", "DT_Request_RTStock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Item"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://halfords.com/xi/out/ecommerce/st", "DT_Request_RTStock_Item"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
