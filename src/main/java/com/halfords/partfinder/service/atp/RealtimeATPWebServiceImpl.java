package com.halfords.partfinder.service.atp;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.rpc.ServiceException;
import javax.xml.ws.BindingProvider;

import org.apache.axis.client.Stub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.halfords.partfinder.dto.ATPInventoryDTO;
import com.halfords.partfinder.dto.ATPInventoryWrapperDTO;
import com.halfords.partfinder.exception.ATPException;
import com.halfords.partfinder.utils.JaxWsHandlerResolver;
import com.halfords.partfinder.utils.ProxyHelper;
import com.halfords.xi.out.ecommerce.rtr.DTRTRStock;
import com.halfords.xi.out.ecommerce.rtr.SIOAsyncRTRStock;
import com.halfords.xi.out.ecommerce.rtr.SIOAsyncRTRStockService;
import com.halfords.xi.out.ecommerce.st.DT_Request_RTStock;
import com.halfords.xi.out.ecommerce.st.DT_Request_RTStock_Item;
import com.halfords.xi.out.ecommerce.st.DT_Response_RTStock;
import com.halfords.xi.out.ecommerce.st.DT_Response_RTStock_Item;
import com.halfords.xi.out.ecommerce.st.MI_O_Sync_Request_RTStock;
import com.halfords.xi.out.ecommerce.st.MI_O_Sync_Request_RTStockServiceLocator;

@Service
public class RealtimeATPWebServiceImpl implements RealtimeATPWebService {
	private static final String CLASSNAME = RealtimeATPWebServiceImpl.class.getName();
	private static final Logger LOGGER = Logger.getLogger(CLASSNAME);
	
	//order number pad to 10 digits with '0'
	private static final int ORDER_NO_LENGTH = 10;
	private static final String ORDER_NO_FORMAT = "0000000000";
	
	//article number pad to 16 digits with '0'
	private static final int ARTICLE_NO_LENGTH = 18;
	private static final String ARTICLE_NO_FORMAT = "000000000000000000";
	private static final String NON_DC = "NON_DC";
	
	private String store1 = "";
	private String store2 = "";
	private String store3 = "";
	private String store4 = "";
	private String store5 = "";
	
    @Value("${st.url}")
    private String stUrl;
    
    @Value("${st.username}")
    private String stUsername;
    
    @Value("${st.password}")
    private String stPassword;
    
    @Value("${st.timeout}")
    private int stTimeout;
    
    @Value("${st.maxtimeout}")
    private int stMaxTimeout;
    
    ///////////////////////////
    
	@Qualifier("objectFactoryRtr")
	@Autowired private com.halfords.xi.out.ecommerce.rtr.ObjectFactory objectFactoryRtr;
	
    @Value("${rtr.url}")
    private String rtrUrl;
    
    @Value("${rtr.username}")
    private String rtrUsername;
    
    @Value("${rtr.password}")
    private String rtrPassword;
    
    ///////////////////////////
    
    @Value("${proxy.host}")
    private String proxyHost;
    
    @Value("${proxy.port}")
    private String proxyPort;
	

    public ATPInventoryDTO[] getATPInventory(ATPInventoryWrapperDTO inventWrapper) throws ATPException {
		final String METHOD = "getATPInventory";
		LOGGER.logp(Level.INFO, CLASSNAME, METHOD, inventWrapper.toString());
		
		final ATPInventoryDTO[] items = inventWrapper.getAtpInventoryDTOs();
		final int[] storeIds = inventWrapper.getStoreIds();
		
		if (items == null || items.length == 0) {
			return items;
		}
		
		setStoreIds(storeIds);
		
		try {
			// we need to copy the content of the items array into an array of webservice-specific objects that form the request
			DT_Request_RTStock_Item[] requestItems = new DT_Request_RTStock_Item[items.length];
		
			for (int i = 0; i < items.length; i++) {
				LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "sku=" + items[i].getSku() + ", DC=" + items[i].getDistributionCentre() + ", Site=" + items[i].getRequestingSite());
				
				requestItems[i] = new DT_Request_RTStock_Item(); 
				requestItems[i].setArticle(items[i].getSku());
				
				//Supplying DC, DC supplying the article.
				if(items[i].isVendorProduct()){
					// NON_DC	
					LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "item is vendor product, set DC to " + NON_DC);
					requestItems[i].setDC(NON_DC);
				} else {
					requestItems[i].setDC(items[i].getDistributionCentre());
				}
				
				requestItems[i].setDC(items[i].getDistributionCentre());
				requestItems[i].setSite(items[i].getRequestingSite());
				
				requestItems[i].setStore1(getStore1());
				requestItems[i].setStore2(getStore2());
				requestItems[i].setStore3(getStore3());
				requestItems[i].setStore4(getStore4());
				requestItems[i].setStore5(getStore5());
			
				// initialize the stock to zero on the request items, in case its not already
				items[i].setStockLevel(0);
			}
		
			setStatus(items, ATPInventoryDTO.STATUS_STOCK_NOT_CHECKED);

			LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "user=" + stUsername);
			LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "pwd=" + stPassword);
			LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "url=" + stUrl);
			LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "timeout=" + stTimeout);
			
			DT_Request_RTStock stock = new DT_Request_RTStock(requestItems);
			MI_O_Sync_Request_RTStockServiceLocator locator = new MI_O_Sync_Request_RTStockServiceLocator();
		
			// set the url of the webservice we're calling.  This will differ between dev/test/staging/prod.
			locator.setMI_O_Sync_Request_RTStockPortEndpointAddress(stUrl);
		
			long startTime = 0;
			boolean executingWebservice = false;
		
			try {
			
				// set Port
				MI_O_Sync_Request_RTStock port = (MI_O_Sync_Request_RTStock) locator.getPort(MI_O_Sync_Request_RTStock.class);
	
				// set the webservice authentication details
				((Stub) port).setUsername(stUsername);
				((Stub) port).setPassword(stPassword);
		
				// set the timeout (milliseconds).  Is this is the connect/read timeout?
				// NOTE: the timeout value is PER PRODUCT.  So, 5 products means 5 times the timeout value!
				((Stub) port).setTimeout(stTimeout);
		
				// make the webservice call
				LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "Start: webservice call");

				executingWebservice = true; 
				startTime = System.currentTimeMillis();
				new ProxyHelper(Integer.valueOf(0), proxyHost, proxyPort).setUpWebServiceProxy();
				
				DT_Response_RTStock response = port.MI_O_Sync_Request_RTStock(stock);
				executingWebservice = false;
				
				
				try {
					// LOG SOAP PAYLOADS
					LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "REQUEST: " + ((Stub) port)._getCall().getMessageContext().getRequestMessage().getSOAPPartAsString());
					LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "RESPONSE: " + ((Stub) port)._getCall().getMessageContext().getResponseMessage().getSOAPPartAsString());
				} catch (Exception e) { // (AxisFault e) {
					e.printStackTrace();
				}


				LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "End: webservice call: " + (System.currentTimeMillis() - startTime));
				
				DT_Response_RTStock_Item[] responseItems = (DT_Response_RTStock_Item[]) response.getItem();
		
				if (responseItems == null){
					LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "response items is null");
				
				} else {
					LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "response items: " + responseItems.length);
					
					for (int i = 0; i < responseItems.length; i++) {
						LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "sku=" + responseItems[i].getArticle() + ", stockLevel=" + responseItems[i].getStock());
						
						for (int j = 0; j < items.length; j++) {
							
							String sku = responseItems[i].getArticle();
							String stockLevel = responseItems[i].getStock();
					
							if (sku.equals(items[j].getSku())) {
								LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "Setting item: " + j + " - " + (items[j] != null ? "Not null" : "null"));
								
								items[j].setStockLevel(new Double(stockLevel).intValue());
								items[j].setStatus(ATPInventoryDTO.STATUS_STOCK_CHECKED);
								items[j].setStore1(responseItems[i].getStore1());
								items[j].setStore2(responseItems[i].getStore2());
								items[j].setStore3(responseItems[i].getStore3());
								items[j].setStore4(responseItems[i].getStore4());
								items[j].setStore5(responseItems[i].getStore5());
								items[j].setDeliveryDate1(responseItems[i].getDate1());
								items[j].setDeliveryDate2(responseItems[i].getDate2());
								items[j].setDeliveryDate3(responseItems[i].getDate3());
								items[j].setDeliveryDate4(responseItems[i].getDate4());
								items[j].setDeliveryDate5(responseItems[i].getDate5());
							}
						}
					}
				}
				LOGGER.exiting(CLASSNAME, METHOD);
				return items;	
				
			} catch (ServiceException e) {
			
				long elapsed = System.currentTimeMillis() - startTime;
				setStatus(items, ATPInventoryDTO.STATUS_WEBSERVICE_ERROR);
				ATPException ex = new ATPException(e);
				if (executingWebservice) {
					ex.setElapsedTime(elapsed);
				}
				throw ex;
			
			} catch (RemoteException e) {
			
				long elapsed = System.currentTimeMillis() - startTime;
				setStatus(items, ATPInventoryDTO.STATUS_WEBSERVICE_ERROR);
				ATPException ex = new ATPException(e);
				if (executingWebservice) {
					ex.setElapsedTime(elapsed);
				}
				throw ex;
			}

		} catch (ATPException e) {
			throw e;
			
		} catch (Exception e ){
			System.out.println("getATPInventory - unexpexpected exception detected");
			e.printStackTrace();
			return items;
		}
	}
	
    
	public void reserveATPInventory(ATPInventoryWrapperDTO inventWrapper) throws ATPException {
		final String METHOD = "reserveATPInventory";
		LOGGER.logp(Level.INFO, CLASSNAME, METHOD, inventWrapper.toString());
		
		String soNumber = inventWrapper.getSoNumber();
		final ATPInventoryDTO[] items = inventWrapper.getAtpInventoryDTOs();
		// final int[] storeIds = invWrapper.getStoreIds();
		
		if(items.length <1){
			return;
		}
		LOGGER.logp(Level.INFO, CLASSNAME, METHOD, ", Site=" + items[0].getRequestingSite() + ", SO number=" + soNumber);
		
		//get the SO number;
		DTRTRStock rtrStock = objectFactoryRtr.createDTRTRStock(); // new com.halfords.xi.out.ecommerce.rtr.ObjectFactory().createDTRTRStock();
		DTRTRStock.RTRHeader rtrHearder = objectFactoryRtr.createDTRTRStockRTRHeader();
		
		
		//Requesting Site, Website accessing SAP to invoke the stock reservation. 		e.g. 0321 for Halfords.com
		rtrHearder.setMovePlant(items[0].getRequestingSite());
		
		if(soNumber.length() < ORDER_NO_LENGTH) {
        	DecimalFormat df = new DecimalFormat(ORDER_NO_FORMAT);
        	soNumber = df.format(new Integer(soNumber).intValue());
		}
		rtrHearder.setReservationOrderNo(soNumber);
		rtrHearder.setResDate(getCurrentTime());
		rtrStock.setRTRHeader(rtrHearder);

		// In the unlikely event that the _DC field is set to any of the following values then do not send the Stock Reservation record. 
		// K
		// K = C
		// R
		// R = R
		final Set excludeDCValues = new HashSet<String>();
		excludeDCValues.add("K");
		excludeDCValues.add("K=C");
		excludeDCValues.add("R");
		excludeDCValues.add("R=R");
		
		for (ATPInventoryDTO inventoryItem:items) {
			LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "sku=" + inventoryItem.getSku() + ", DC=" + inventoryItem.getDistributionCentre() + ", Total quantity=" + inventoryItem.getRequiredStockLevel());
			
			//In the unlikely event that the _DC field is set to any of the following values then do not send the Stock Reservation record. 
			if(inventoryItem.getDistributionCentre() != null && excludeDCValues.contains(inventoryItem.getDistributionCentre().trim().replaceAll(" ", ""))){
				LOGGER.logp(Level.INFO, CLASSNAME, METHOD, " DC=" + inventoryItem.getDistributionCentre() + ",  the _DC field is set to any of the following values: K, K=C, R, R=R,  then do not send the Stock Reservation record");
				continue;
			}
			
			DTRTRStock.RTRItem rtrItem = objectFactoryRtr.createDTRTRStockRTRItem();
			String articleNumber = inventoryItem.getSku();
			//Article number
			
			if(articleNumber.length() < ARTICLE_NO_LENGTH){
	        	DecimalFormat df = new DecimalFormat(ARTICLE_NO_FORMAT);
	        	articleNumber = df.format(new Integer(articleNumber).intValue());
			}
			rtrItem.setMaterial(articleNumber);
			//Supplying DC, DC supplying the article.
			if(inventoryItem.isVendorProduct()){
				// NODC	
				LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "item is vendor product, set DC to " + NON_DC);
				rtrItem.setPlant(NON_DC);
			} else {
				rtrItem.setPlant(inventoryItem.getDistributionCentre());	
			}
			
			// Total quantity
			rtrItem.setEntryQnt(new Integer(inventoryItem.getRequiredStockLevel()).toString());
			rtrStock.getRTRItem().add(rtrItem);
		}
		
		SIOAsyncRTRStockService service = new SIOAsyncRTRStockService();
		service.setHandlerResolver(new JaxWsHandlerResolver()); // LOG SOAP PAYLOADS
		
		SIOAsyncRTRStock port = service.getPort(SIOAsyncRTRStock.class);

		if (LOGGER.isLoggable(Level.FINER)) {
			LOGGER.logp(Level.FINER, CLASSNAME, METHOD, BindingProvider.ENDPOINT_ADDRESS_PROPERTY + " is: " + rtrUrl);
		}				
		BindingProvider provider = (BindingProvider) port;
		provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, rtrUrl);
		provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, rtrUsername);
		provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, rtrPassword);
		
		if (LOGGER.isLoggable(Level.FINER)) {
			LOGGER.logp(Level.FINER, CLASSNAME, METHOD, "the number of RTR items is: " + rtrStock.getRTRItem().size());
			LOGGER.logp(Level.FINER, CLASSNAME, METHOD, "the order number of RTR is: " + rtrStock.getRTRHeader().getReservationOrderNo());
		}

		// make the webservice call
		LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "Start: RTR webservice call, there will be no response ");
		port.siOAsyncRTRStock(rtrStock);
		
		LOGGER.exiting(CLASSNAME, METHOD);
	}
	
	private String getCurrentTime() {
		//Date & Time: Date and time stamp of time RTR web service invoked.		Format YYMMDDHHMMSS

		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
		
		String time = sdf.format( calendar.getTime() );
		return time;
	}
	
	protected void setStatus(ATPInventoryDTO[] items, int status) {
		for (int i = 0; i < items.length; i++) {
			items[i].setStatus(status);
		}
	}
	
	/**
	 * Set Store Ids
	 * @param storeIds
	 */
	private void setStoreIds(final int[] storeIds) {
		setStore1("");
		setStore2("");
		setStore3("");
		setStore4("");
		setStore5("");
		
		if (storeIds != null) {
			for (int i = 0; i < storeIds.length; i++) {
				String storeId = String.valueOf(storeIds[i]);
				if (!hasValue(getStore1())) {
					setStore1(storeId);
				} else if (!hasValue(getStore2())) {
					setStore2(storeId);
				} else if (!hasValue(getStore3())) {
					setStore3(storeId);
				} else if (!hasValue(getStore4())) {
					setStore4(storeId);
				} else if (!hasValue(getStore5())) {
					setStore5(storeId);
				}
			}
		}
	}
	
	/**
	 * Determines whether or not the supplied value has a value
	 * @param pValue
	 * @return
	 */
	private boolean hasValue(final String pValue) {
		boolean lReturn = false;
		if (pValue != null && pValue.trim().length() > 0) {
			lReturn = true;
		}
		return lReturn;
	}
	
	public String getStore1() {
		return store1;
	}

	public String getStore2() {
		return store2;
	}

	public String getStore3() {
		return store3;
	}

	public String getStore4() {
		return store4;
	}

	public String getStore5() {
		return store5;
	}

	public void setStore1(String string) {
		store1 = string;
	}

	public void setStore2(String string) {
		store2 = string;
	}

	public void setStore3(String string) {
		store3 = string;
	}

	public void setStore4(String string) {
		store4 = string;
	}

	public void setStore5(String string) {
		store5 = string;
	}
}
