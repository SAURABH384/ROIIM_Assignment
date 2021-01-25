package com.ROIIM.Assignment.entity;

public class Payment {
	private String id;
	private Integer amount;
	private String merchantRefNum;
	private Boolean settleWithAuth;
	private String paymentHandleToken;
	private String txnTime;
	private String customerIp;
	private Boolean dupCheck;
	private String description;
	private String currencyCode;
	private String paymentType;
	private String status;
	private Integer availableToSettle;
	private String customerId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getMerchantRefNum() {
		return merchantRefNum;
	}
	public void setMerchantRefNum(String merchantRefNum) {
		this.merchantRefNum = merchantRefNum;
	}
	public Boolean getSettleWithAuth() {
		return settleWithAuth;
	}
	public void setSettleWithAuth(Boolean settleWithAuth) {
		this.settleWithAuth = settleWithAuth;
	}
	public String getPaymentHandleToken() {
		return paymentHandleToken;
	}
	public void setPaymentHandleToken(String paymentHandleToken) {
		this.paymentHandleToken = paymentHandleToken;
	}
	public String getTxnTime() {
		return txnTime;
	}
	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}
	public String getCustomerIp() {
		return customerIp;
	}
	public void setCustomerIp(String customerIp) {
		this.customerIp = customerIp;
	}
	public Boolean getDupCheck() {
		return dupCheck;
	}
	public void setDupCheck(Boolean dupCheck) {
		this.dupCheck = dupCheck;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getAvailableToSettle() {
		return availableToSettle;
	}
	public void setAvailableToSettle(Integer availableToSettle) {
		this.availableToSettle = availableToSettle;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", merchantRefNum=" + merchantRefNum + ", settleWithAuth="
				+ settleWithAuth + ", paymentHandleToken=" + paymentHandleToken + ", txnTime=" + txnTime
				+ ", customerIp=" + customerIp + ", dupCheck=" + dupCheck + ", description=" + description
				+ ", currencyCode=" + currencyCode + ", paymentType=" + paymentType + ", status=" + status
				+ ", availableToSettle=" + availableToSettle + ", customerId=" + customerId + "]";
	}
	
}
