package com.halfords.partfinder.dto;

import java.util.Arrays;

public class ATPInventoryWrapperDTO {
	
	private String soNumber;
	private ATPInventoryDTO[] atpInventoryDTOs;
	private int[] storeIds;
	
	public ATPInventoryWrapperDTO() {
		super();
	}

	public String getSoNumber() {
		return soNumber;
	}

	public void setSoNumber(String soNumber) {
		this.soNumber = soNumber;
	}

	public ATPInventoryDTO[] getAtpInventoryDTOs() {
		return atpInventoryDTOs;
	}

	public void setAtpInventoryDTOs(ATPInventoryDTO[] atpInventoryDTOs) {
		this.atpInventoryDTOs = atpInventoryDTOs;
	}

	public int[] getStoreIds() {
		return storeIds;
	}

	public void setStoreIds(int[] storeIds) {
		this.storeIds = storeIds;
	}

	@Override
	public String toString() {
		return "ATPInventoryWrapperDTO [soNumber=" + soNumber + ", atpInventoryDTOs="
				+ Arrays.toString(atpInventoryDTOs) + ", storeIds=" + Arrays.toString(storeIds) + "]";
	}
}
