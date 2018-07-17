package com.halfords.partfinder.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.halfords.partfinder.service.atp.RealtimeATPWebServiceImpl;

public class ServiceLogHandler implements SOAPHandler<SOAPMessageContext> {
	
	private static final String CLASSNAME = RealtimeATPWebServiceImpl.class.getName();
	private static final Logger LOGGER = Logger.getLogger(CLASSNAME);
	
	@Override
	public Set<QName> getHeaders() {
		return null;
	}

    @Override
    public void close(MessageContext arg0) {
    }
 
    @Override
    public boolean handleFault(SOAPMessageContext arg0) {
        SOAPMessage message = arg0.getMessage();
        try {
            message.writeTo(System.out);
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
 
    @Override
    public boolean handleMessage(SOAPMessageContext arg0) {
        SOAPMessage message = arg0.getMessage();
        boolean isOutboundMessage = (Boolean) arg0.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        
        if (isOutboundMessage) {
            logMessage("OUTBOUND MESSAGE: ", message);
            
        } else {
            logMessage("INBOUND MESSAGE: ", message);
        }
            
        return true;
    }
    
    private void logMessage(final String type, final SOAPMessage msg) {
    	final String METHOD = "logMessage";
    	
    	ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            msg.writeTo(baos);
            LOGGER.logp(Level.INFO, CLASSNAME, METHOD, type + baos.toString());
            
        } catch (final Exception e) {
            LOGGER.logp(Level.WARNING, CLASSNAME, METHOD, "Caught exception: " + e.getMessage(), e);
        
        } finally {
        	try {
        		baos.close();
        	} catch (Exception e) {}
        }
    }
}