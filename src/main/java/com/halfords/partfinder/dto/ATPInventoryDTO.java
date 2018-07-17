package com.halfords.partfinder.dto;

import java.util.ArrayList;
import java.util.List;

public class ATPInventoryDTO {
	
	public static final int STATUS_STOCK_NOT_CHECKED = 0;
	public static final int STATUS_STOCK_CHECKED = 1;
	public static final int STATUS_WEBSERVICE_ERROR = 2;

	private String sku;
	private String distributionCentre;
	private String requestingSite;
	private int actualStockLevel;
	private int requiredStockLevel;

	private String store1 = "";
	private String store2 = "";
	private String store3 = "";
	private String store4 = "";
	private String store5 = "";

	private String deliveryDate1 = "";
	private String deliveryDate2 = "";
	private String deliveryDate3 = "";
	private String deliveryDate4 = "";
	private String deliveryDate5 = "";
	
	private boolean dcProduct = false;
	private boolean vendorProduct = false;
	
	// Order Items represented by the Bean
	private List<Long> orderItemIds	= new ArrayList<Long>();
	
	private int status;

	public ATPInventoryDTO() {
		super();
	}

	public ATPInventoryDTO(String sku, String distributionCentre, String requestingSite, int requiredStockLevel, boolean isDcProduct, boolean isVendorProduct) {
		this.sku = sku;
		this.distributionCentre = distributionCentre;
		this.requestingSite = requestingSite;
		this.requiredStockLevel = requiredStockLevel;
		this.dcProduct = isDcProduct;
		this.vendorProduct = isVendorProduct;
	}
	
	public boolean isStockChecked() {
		return this.status == STATUS_STOCK_CHECKED;
	}
	
	public boolean isWebServiceError() {
		return this.status == STATUS_WEBSERVICE_ERROR;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public void setStatus(int status) {
		switch (status) {
			
			case STATUS_STOCK_NOT_CHECKED:
			case STATUS_STOCK_CHECKED:
			case STATUS_WEBSERVICE_ERROR:
				this.status = status;
				break;
				
			default: throw new RuntimeException("Invalid status: " + status);
		}
	}

	/**
	 * @return
	 */
	public String getDistributionCentre() {
		return distributionCentre;
	}

	/**
	 * @return
	 */
	public String getRequestingSite() {
		return requestingSite;
	}

	/**
	 * @return
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @return
	 */
	public int getStockLevel() {
		return actualStockLevel;
	}

	/**
	 * @return
	 */
	public String getStore1() {
		return store1;
	}

	/**
	 * @return
	 */
	public String getStore2() {
		return store2;
	}

	/**
	 * @return
	 */
	public String getStore3() {
		return store3;
	}

	/**
	 * @return
	 */
	public String getStore4() {
		return store4;
	}

	/**
	 * @return
	 */
	public String getStore5() {
		return store5;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public void setDistributionCentre(String distributionCentre) {
		this.distributionCentre = distributionCentre;
	}

	public void setRequestingSite(String requestingSite) {
		this.requestingSite = requestingSite;
	}

	public void setActualStockLevel(int actualStockLevel) {
		this.actualStockLevel = actualStockLevel;
	}

	/**
	 * @param i
	 */
	public void setStockLevel(int i) {
		actualStockLevel = i;
	}

	/**
	 * @param string
	 */
	public void setStore1(String string) {
		store1 = string;
	}

	/**
	 * @param string
	 */
	public void setStore2(String string) {
		store2 = string;
	}

	/**
	 * @param string
	 */
	public void setStore3(String string) {
		store3 = string;
	}

	/**
	 * @param string
	 */
	public void setStore4(String string) {
		store4 = string;
	}

	/**
	 * @param string
	 */
	public void setStore5(String string) {
		store5 = string;
	}
	
	public int getRequiredStockLevel() {
		return this.requiredStockLevel;
	}
	
	public void setRequiredStockLevel(int qty) {
		this.requiredStockLevel = qty;
	}
	
	/**
	 * A convenience method that increases the required stock level
	 * by the specified amount. i.e. the specified amount is in
	 * addition to the existing required quantity.
	 * 
	 * @param qty additional quantity required
	 */
	public void increaseRequiredStockLevel(int qty) {
		setRequiredStockLevel(getRequiredStockLevel() + qty);
	}
	
	/**
	 * Returns true of the quantity of required stock can be met from the actuall stock level.
	 * NOTE: this only makes sense if the item was actually stock checked - so check the
	 * status equals STATUS_STOCK_CHECKED first!
	 * 
	 * @return
	 */
	public boolean hasSufficientStock() {
		return getRequiredStockLevel() <= getStockLevel();
	}
	
	/**
	 * Returns the realtime ATP Delivery Date for the specified Store, or null if unknown.
	 * 
	 * @param storeId
	 * @return Delivery Date, or null if unknown.
	 */
	public String getDeliveryDate(final String storeId) {
		String deliveryDate = null;
		if (isRequiredStore(getStore1(), storeId)) {
			deliveryDate = getDeliveryDate1();
		} else if (isRequiredStore(getStore2(), storeId)) {
			deliveryDate = getDeliveryDate2();
		} else if (isRequiredStore(getStore3(), storeId)) {
			deliveryDate = getDeliveryDate3();
		} else if (isRequiredStore(getStore4(), storeId)) {
			deliveryDate = getDeliveryDate4();
		} else if (isRequiredStore(getStore5(), storeId)) {
			deliveryDate = getDeliveryDate5();
		}
		return deliveryDate;
	}
	
	/**
	 * Determines whether or not the required store is found 
	 * @param storeId
	 * @param requiredStoreId
	 * @return
	 */
	private boolean isRequiredStore(final String storeId, final String requiredStoreId) {
		if (storeId != null && storeId.equals(requiredStoreId)) {
			return true;
		} else {
			return false;
		}
	}

	public String getDeliveryDate1() {
		return deliveryDate1;
	}

	public String getDeliveryDate2() {
		return deliveryDate2;
	}

	public String getDeliveryDate3() {
		return deliveryDate3;
	}

	public String getDeliveryDate4() {
		return deliveryDate4;
	}

	public String getDeliveryDate5() {
		return deliveryDate5;
	}

	public void setDeliveryDate1(String string) {
		deliveryDate1 = string;
	}

	public void setDeliveryDate2(String string) {
		deliveryDate2 = string;
	}

	public void setDeliveryDate3(String string) {
		deliveryDate3 = string;
	}

	public void setDeliveryDate4(String string) {
		deliveryDate4 = string;
	}

	public void setDeliveryDate5(String string) {
		deliveryDate5 = string;
	}

	public List<Long> getOrderItemIds() {
		return orderItemIds;
	}

	public void setOrderItemIds(List<Long> list) {
		orderItemIds = list;
	}

	public boolean isDcProduct() {
		return dcProduct;
	}

	public void setDcProduct(boolean dcProduct) {
		this.dcProduct = dcProduct;
	}

	public boolean isVendorProduct() {
		return vendorProduct;
	}

	public void setVendorProduct(boolean vendorProduct) {
		this.vendorProduct = vendorProduct;
	}

	@Override
	public String toString() {
		return "ATPInventoryDTO [sku=" + sku + ", distributionCentre=" + distributionCentre + ", requestingSite="
				+ requestingSite + ", actualStockLevel=" + actualStockLevel + ", requiredStockLevel="
				+ requiredStockLevel + ", store1=" + store1 + ", store2=" + store2 + ", store3=" + store3 + ", store4="
				+ store4 + ", store5=" + store5 + ", deliveryDate1=" + deliveryDate1 + ", deliveryDate2="
				+ deliveryDate2 + ", deliveryDate3=" + deliveryDate3 + ", deliveryDate4=" + deliveryDate4
				+ ", deliveryDate5=" + deliveryDate5 + ", dcProduct=" + dcProduct + ", vendorProduct=" + vendorProduct
				+ ", orderItemIds=" + orderItemIds + ", status=" + status + "]";
	}
}
