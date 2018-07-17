/**
 * MI_O_Sync_Request_RTStockServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package com.halfords.xi.out.ecommerce.st;

@SuppressWarnings("unchecked")
public class MI_O_Sync_Request_RTStockServiceLocator extends org.apache.axis.client.Service implements com.halfords.xi.out.ecommerce.st.MI_O_Sync_Request_RTStockService {

    public MI_O_Sync_Request_RTStockServiceLocator() {
    }


    public MI_O_Sync_Request_RTStockServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MI_O_Sync_Request_RTStockServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MI_O_Sync_Request_RTStockPort
    private java.lang.String MI_O_Sync_Request_RTStockPort_address = "http://10.1.2.94:50000/XISOAPAdapter/MessageServlet?channel=:ECommerce:CC_EcomRTStockRequestSender_RD1_104&version=3.0&Sender.Service=ECOMMERCE+&Interface=http%3A%2F%2Fhalfords.com%2Fxi%2Fout%2Fecommerce%2Fst%5EMI_O_Sync_Request_RTStock";

    public java.lang.String getMI_O_Sync_Request_RTStockPortAddress() {
        return MI_O_Sync_Request_RTStockPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MI_O_Sync_Request_RTStockPortWSDDServiceName = "MI_O_Sync_Request_RTStockPort";

    public java.lang.String getMI_O_Sync_Request_RTStockPortWSDDServiceName() {
        return MI_O_Sync_Request_RTStockPortWSDDServiceName;
    }

    public void setMI_O_Sync_Request_RTStockPortWSDDServiceName(java.lang.String name) {
        MI_O_Sync_Request_RTStockPortWSDDServiceName = name;
    }

    public com.halfords.xi.out.ecommerce.st.MI_O_Sync_Request_RTStock getMI_O_Sync_Request_RTStockPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MI_O_Sync_Request_RTStockPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMI_O_Sync_Request_RTStockPort(endpoint);
    }

    public com.halfords.xi.out.ecommerce.st.MI_O_Sync_Request_RTStock getMI_O_Sync_Request_RTStockPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.halfords.xi.out.ecommerce.st.MI_O_Sync_Request_RTStockBindingStub _stub = new com.halfords.xi.out.ecommerce.st.MI_O_Sync_Request_RTStockBindingStub(portAddress, this);
            _stub.setPortName(getMI_O_Sync_Request_RTStockPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMI_O_Sync_Request_RTStockPortEndpointAddress(java.lang.String address) {
        MI_O_Sync_Request_RTStockPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.halfords.xi.out.ecommerce.st.MI_O_Sync_Request_RTStock.class.isAssignableFrom(serviceEndpointInterface)) {
                com.halfords.xi.out.ecommerce.st.MI_O_Sync_Request_RTStockBindingStub _stub = new com.halfords.xi.out.ecommerce.st.MI_O_Sync_Request_RTStockBindingStub(new java.net.URL(MI_O_Sync_Request_RTStockPort_address), this);
                _stub.setPortName(getMI_O_Sync_Request_RTStockPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MI_O_Sync_Request_RTStockPort".equals(inputPortName)) {
            return getMI_O_Sync_Request_RTStockPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://halfords.com/xi/out/ecommerce/st", "MI_O_Sync_Request_RTStockService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://halfords.com/xi/out/ecommerce/st", "MI_O_Sync_Request_RTStockPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MI_O_Sync_Request_RTStockPort".equals(portName)) {
            setMI_O_Sync_Request_RTStockPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
