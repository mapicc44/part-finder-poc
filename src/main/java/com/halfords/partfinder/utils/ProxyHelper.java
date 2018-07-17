package com.halfords.partfinder.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.axis.AxisProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;


public class ProxyHelper {
	
	private static final String CLASSNAME  = ProxyHelper.class.getName();
	private static final Logger LOGGER = Logger.getLogger(CLASSNAME);

	private Integer storeId;
	private String proxyHost;
	private String proxyPort;
	
	public ProxyHelper(Integer storeId, String proxyHost, String proxyPort) {
		this.storeId = storeId;
		this.proxyHost = proxyHost;
		this.proxyPort = proxyPort;
	}
	
	public void setUpWebServiceProxy() {
		final String METHODNAME = "setUpWebServiceProxy";
		
		if (isProxyUsed()) {
			LOGGER.logp(Level.INFO, CLASSNAME, METHODNAME, "Using proxy: " + getProxyHost() + ":" + getProxyPort());
			
			AxisProperties.setProperty("http.proxySet", "true");
			AxisProperties.setProperty("http.proxyHost", getProxyHost());
			AxisProperties.setProperty("http.proxyPort", getProxyPort());
//			AxisProperties.setProperty("http.nonProxyHosts", getNonProxyHosts());
			
		} else {
			LOGGER.logp(Level.INFO, CLASSNAME, METHODNAME, "Proxy not being used");
		}
	}

	public boolean isProxyUsed() {
		return StringUtils.isNotEmpty(getProxyHost()) && StringUtils.isNotEmpty(getProxyPort());
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public String getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(String proxyPort) {
		this.proxyPort = proxyPort;
	}
	
//	private String getNonProxyHosts(){
//		return CommonRegistryHelper.getRegistryValue(storeId.toString(), HalfordsConstants.REG_NON_PROXY_HOSTS, null);
//	}
}
