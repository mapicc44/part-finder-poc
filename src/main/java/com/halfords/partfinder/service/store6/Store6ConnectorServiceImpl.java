package com.halfords.partfinder.service.store6;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.halfords.connectors.sap.store6.ArrayOfArticleStockLevels;
import com.halfords.connectors.sap.store6.ArrayOfArticleStockLevelsStoreStockLevel;
import com.halfords.connectors.sap.store6.ArticleStockLevels;
import com.halfords.connectors.sap.store6.ArticleStockLevelsStoreStockLevel;
import com.halfords.connectors.sap.store6.GetAvailability;
import com.halfords.connectors.sap.store6.ObjectFactory;
import com.halfords.connectors.sap.store6.StockLevelRequest;
import com.halfords.partfinder.exception.Store6ConnectorException;

/**
 * Connector class for Store6 functionality exposed via SAP
 */
@Service
public class Store6ConnectorServiceImpl implements Store6ConnectorService {

	private static final String CLASSNAME = Store6ConnectorServiceImpl.class.getName();
	private static final Logger LOGGER = Logger.getLogger(CLASSNAME);
	
	@Qualifier("objectFactoryStore6")
	@Autowired private ObjectFactory objectFactory;
	
	@Qualifier("webServiceTemplateStore6")
    @Autowired private WebServiceTemplate webServiceTemplate;
	
	@Override
	public StockLevelRequest getStockAvailability(final int[] hssIds, final String partNumber, final int quantity)
			throws Store6ConnectorException {
		return getStockAvailability(hssIds, new ArrayList<Pair<String, Integer>>() {
			private static final long serialVersionUID = 1L;
			{
				add(ImmutablePair.of(partNumber, quantity));
			}
		});
	}

	@Override
	public StockLevelRequest getStockAvailability(int[] hssIds, List<Pair<String, Integer>> items) throws Store6ConnectorException {
		final String METHOD = "getStockAvailability";
		LOGGER.entering(CLASSNAME, METHOD, new Object[] {hssIds, items});
		
		StockLevelRequest response = null;
		ArrayOfArticleStockLevelsStoreStockLevel arrayOfArticleStockLevelsStoreStockLevel = objectFactory.createArrayOfArticleStockLevelsStoreStockLevel();
		
		for (int storeId: hssIds) {
			ArticleStockLevelsStoreStockLevel articleStockLevelsStoreStockLevel = objectFactory.createArticleStockLevelsStoreStockLevel();
			articleStockLevelsStoreStockLevel.setStoreNumber(storeId);
			arrayOfArticleStockLevelsStoreStockLevel.getArticleStockLevelsStoreStockLevel().add(articleStockLevelsStoreStockLevel);
		}
		
		final ArrayOfArticleStockLevels arrayOfArticleStockLevels = objectFactory.createArrayOfArticleStockLevels();
		
		for (final Pair<String, Integer> item: items) {
			ArticleStockLevels articleStockLevels = objectFactory.createArticleStockLevels();
			articleStockLevels.setArticleNumber(objectFactory.createArticleStockLevelsArticleNumber(item.getLeft()));
			articleStockLevels.setQtyRequired(item.getRight());
			articleStockLevels.setStoresStockLevels(objectFactory.createArticleStockLevelsStoresStockLevels(arrayOfArticleStockLevelsStoreStockLevel));
			
			arrayOfArticleStockLevels.getArticleStockLevels().add(articleStockLevels);
		}
		
		StockLevelRequest stockLevelRequest = objectFactory.createStockLevelRequest();
		stockLevelRequest.setArticlesStockLevels(objectFactory.createStockLevelRequestArticlesStockLevels(arrayOfArticleStockLevels));
		
		 try {
			GetAvailability getAvailability = objectFactory.createGetAvailability();
			getAvailability.setStockrequest(objectFactory.createGetAvailabilityStockrequest(stockLevelRequest));

			response = (StockLevelRequest) webServiceTemplate.marshalSendAndReceive(stockLevelRequest);
			return response;

		} catch (Exception e) {
			throw new Store6ConnectorException(e.getMessage());
		
		} finally {
			// timeLogger.stopAndPrint();
			 LOGGER.exiting(CLASSNAME, METHOD, response);
		}
	}
}
