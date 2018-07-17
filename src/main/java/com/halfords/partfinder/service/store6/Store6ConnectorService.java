package com.halfords.partfinder.service.store6;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import com.halfords.connectors.sap.store6.StockLevelRequest;
import com.halfords.partfinder.exception.Store6ConnectorException;

public interface Store6ConnectorService {

	/**
	 * Determines stock availability on a store-by-store basis.  
	 * @param hssIds Identifies the high street stores to check for stock levels
	 * @param partNumber SAP article number (SKU with '-0' removed)
	 * @param quantity Quantity
	 * @return List of stores and their stock levels
	 * @throws Store6ConnectorException 
	 */
	public StockLevelRequest getStockAvailability(int[] hssIds, String partNumber, int quantity) throws Store6ConnectorException;

	/**
	 * Determines stock availability on a store-by-store basis.  
	 * @param hssIds Identifies the high street stores to check for stock levels
	 * @param items List of product/quantity pairs
	 * @return List of stores and their stock levels
	 * @throws Store6ConnectorException 
	 */
	public StockLevelRequest getStockAvailability(int[] hssIds, List<Pair<String, Integer>> items) throws Store6ConnectorException;
}
