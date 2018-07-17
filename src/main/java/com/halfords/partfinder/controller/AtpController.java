package com.halfords.partfinder.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.halfords.partfinder.dto.ATPInventoryDTO;
import com.halfords.partfinder.dto.ATPInventoryWrapperDTO;
import com.halfords.partfinder.service.atp.RealtimeATPWebService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/atp")
@Api(value = "/atp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class AtpController {
	
	private static final String CLASSNAME = AtpController.class.getName();
	private static final Logger LOGGER = Logger.getLogger(CLASSNAME);

	@Autowired
	private RealtimeATPWebService realtimeATPWebService;
	
	
	@RequestMapping(value = "/st", method = RequestMethod.POST)
    @ApiOperation(value = "Gets ATP inventory calling 3rd party endpoint.", response = ATPInventoryDTO[].class, httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success"), 
    		@ApiResponse(code = 401, message = "Not Authorised"),
    		@ApiResponse(code = 500, message = "Internal Server Error") 
    })
	public ATPInventoryDTO[] getATPInventory(@RequestBody ATPInventoryWrapperDTO invWrapper) throws Exception {
		
		final String METHOD = "getATPInventory";
		LOGGER.entering(CLASSNAME, METHOD, invWrapper);
		
		ATPInventoryDTO[] response = realtimeATPWebService.getATPInventory(invWrapper);
		
		LOGGER.exiting(CLASSNAME, METHOD, response);
		return response;
	}
	
	
	@RequestMapping(value = "/rtr", method = RequestMethod.POST)
    @ApiOperation(value = "Reserve ATP inventory calling 3rd party endpoint.", response = ATPInventoryDTO[].class, httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success"), 
    		@ApiResponse(code = 401, message = "Not Authorised"),
    		@ApiResponse(code = 500, message = "Internal Server Error") 
    })
	public void reserveATPInventory(@RequestBody ATPInventoryWrapperDTO invWrapper) throws Exception {
		
		final String METHOD = "reserveATPInventory";
		LOGGER.entering(CLASSNAME, METHOD, invWrapper);
		
		realtimeATPWebService.reserveATPInventory(invWrapper);

		LOGGER.exiting(CLASSNAME, METHOD);
	}
}
