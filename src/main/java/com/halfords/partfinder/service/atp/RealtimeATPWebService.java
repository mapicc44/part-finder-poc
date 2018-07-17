package com.halfords.partfinder.service.atp;

import com.halfords.partfinder.dto.ATPInventoryDTO;
import com.halfords.partfinder.dto.ATPInventoryWrapperDTO;
import com.halfords.partfinder.exception.ATPException;

public interface RealtimeATPWebService {

	/**
	 * Given an array of objects containing the details of the items to stock check,
	 * this method returns the same array but with the stock figure populated.
	 * 
	 * @param invWrapper
	 * @return
	 * @throws ATPException
	 */
	ATPInventoryDTO[] getATPInventory(ATPInventoryWrapperDTO invWrapper) throws ATPException;
	
	/**
	 * Given an array of objects containing the details of the items to stock reserve,
	 * this method reserve the items on SAP.
	 * 
	 * @param invWrapper
	 * @throws ATPException
	 */
	void reserveATPInventory(ATPInventoryWrapperDTO invWrapper) throws ATPException;
}
