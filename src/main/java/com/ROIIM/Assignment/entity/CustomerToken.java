package com.ROIIM.Assignment.entity;

import java.util.List;

public class CustomerToken {
	private String id;
    private String merchantRefNum;
    private Integer timeToLiveSeconds;
	private String status;
    private String singleUseCustomerToken;
    private List<String> paymentTypes;
    private String locale;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMerchantRefNum() {
		return merchantRefNum;
	}
	public void setMerchantRefNum(String merchantRefNum) {
		this.merchantRefNum = merchantRefNum;
	}
	public Integer getTimeToLiveSeconds() {
		return timeToLiveSeconds;
	}
	public void setTimeToLiveSeconds(Integer timeToLiveSeconds) {
		this.timeToLiveSeconds = timeToLiveSeconds;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSingleUseCustomerToken() {
		return singleUseCustomerToken;
	}
	public void setSingleUseCustomerToken(String singleUseCustomerToken) {
		this.singleUseCustomerToken = singleUseCustomerToken;
	}
	public List<String> getPaymentTypes() {
		return paymentTypes;
	}
	public void setPaymentTypes(List<String> paymentTypes) {
		this.paymentTypes = paymentTypes;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	@Override
	public String toString() {
		return "CustomerToken [id=" + id + ", merchantRefNum=" + merchantRefNum + ", timeToLiveSeconds="
				+ timeToLiveSeconds + ", status=" + status + ", singleUseCustomerToken=" + singleUseCustomerToken
				+ ", paymentTypes=" + paymentTypes + ", locale=" + locale + "]";
	}
    
}
