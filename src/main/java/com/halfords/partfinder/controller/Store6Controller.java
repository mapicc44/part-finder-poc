package com.halfords.partfinder.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.halfords.connectors.sap.store6.StockLevelRequest;
import com.halfords.partfinder.dto.ATPInventoryDTO;
import com.halfords.partfinder.service.store6.Store6ConnectorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/store6")
@Api(value = "/store6", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class Store6Controller {

	private static final String CLASSNAME = Store6Controller.class.getName();
	private static final Logger LOGGER = Logger.getLogger(CLASSNAME);
	
	@Autowired
	private Store6ConnectorService store6ConnectorService;
	
	@RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Gets Store6 inventory calling 3rd party (Store6) endpoint.", response = ATPInventoryDTO[].class, httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success"), 
    		@ApiResponse(code = 401, message = "Not Authorised"),
    		@ApiResponse(code = 500, message = "Internal Server Error") 
    })
    public StockLevelRequest getStockAvailabilityStore6 (
    			@RequestParam(value="hssId") int hssId, 
    			@RequestParam(value="partNum") String partNum,
    			@RequestParam(value="quantity") int quantity
    		) throws Exception {
		
		final String METHOD = "getStockAvailabilityStore6";
		LOGGER.entering(CLASSNAME, METHOD, new Object[] {hssId, partNum, quantity});
		
		StockLevelRequest response = store6ConnectorService.getStockAvailability(new int[] {hssId}, partNum, quantity);
        
        LOGGER.exiting(CLASSNAME, METHOD, response);
        return response;
    }
}
