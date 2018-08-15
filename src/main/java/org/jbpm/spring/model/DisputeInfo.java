package org.jbpm.spring.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DisputeInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String accountName ;
	private String merchantName;
	private String transactionDate;
	private String disputeReason;
	private String areyoudisbutefullamount;
	private String transactionAmount;
	private String disputeAmount;
	private Date transDate;
	private String url;
	private String smsMobile;
	private String contactPhone;
	private String emailId;
	private String merchantLocation;
	private String transactionId;
	private String[] disputeAmounts;
	List<Activity> activities;
	
	
	
	public List<Activity> getActivities() {
		return activities;
	}
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getDisputeReason() {
		return disputeReason;
	}
	public void setDisputeReason(String disputeReason) {
		this.disputeReason = disputeReason;
	}
	public String getAreyoudisbutefullamount() {
		return areyoudisbutefullamount;
	}
	public void setAreyoudisbutefullamount(String areyoudisbutefullamount) {
		this.areyoudisbutefullamount = areyoudisbutefullamount;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getDisputeAmount() {
		return disputeAmount;
	}
	public void setDisputeAmount(String disputeAmount) {
		this.disputeAmount = disputeAmount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public String getSmsMobile() {
		return smsMobile;
	}
	public void setSmsMobile(String smsMobile) {
		this.smsMobile = smsMobile;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMerchantLocation() {
		return merchantLocation;
	}
	public void setMerchantLocation(String merchantLocation) {
		this.merchantLocation = merchantLocation;
	}
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	
	public String[] getDisputeAmounts() {
		return disputeAmounts;
	}
	public void setDisputeAmounts(String[] disputeAmounts) {
		this.disputeAmounts = disputeAmounts;
	}
	@Override
	public String toString() {
		return "DisputeInfo [accountName=" + accountName + ", merchantName=" + merchantName + ", transactionDate="
				+ transactionDate + ", disputeReason=" + disputeReason + ", areyoudisbutefullamount="
				+ areyoudisbutefullamount + ", transactionAmount=" + transactionAmount + ", disputeAmount="
				+ disputeAmount + ", transDate=" + transDate + ", url=" + url + ", smsMobile=" + smsMobile
				+ ", contactPhone=" + contactPhone + ", emailId=" + emailId + ", merchantLocation=" + merchantLocation
				+ ", transactionId=" + transactionId + ", disputeAmounts=" + Arrays.toString(disputeAmounts)
				+ ", activities=" + activities + "]";
	}
	
	
	

}
