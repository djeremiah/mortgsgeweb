package org.jbpm.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class AccountInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="accountid")
	private String accountid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private String status;
	
	@Column(name="partner")
	private String partner;
	
	@Column(name="autopayment")
	private String autoPayment;
	
	@Column(name="accountno")
	private String accountNumber;
	
	@Column(name="bankname")
	private String bankName;
	
	@Column(name="routingnumber")
	private String routingnumber;
	
	@Column(name="paynotificationDays")
	private Integer paymentNotificationDays;
	
	@Column(name="smsnotification")
	private String smsNotificationNo;
	
	@Column(name="emailnotification")
	private String emailNotification;
	
	
	@OneToMany(targetEntity=AccountInfo.class)
	//@JoinColumn(name="accountid", referencedColumnName="accountid")
	 private List<Transaction> transactions;
	
	@OneToMany(targetEntity=AccountInfo.class)
	//@JoinColumn(name="accountid", referencedColumnName="accountid")
	 private List<AccountBalance> accountBalances;

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getAutoPayment() {
		return autoPayment;
	}

	public void setAutoPayment(String autoPayment) {
		this.autoPayment = autoPayment;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getRoutingnumber() {
		return routingnumber;
	}

	public void setRoutingnumber(String routingnumber) {
		this.routingnumber = routingnumber;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	
	public Integer getPaymentNotificationDays() {
		return paymentNotificationDays;
	}

	public void setPaymentNotificationDays(Integer paymentNotificationDays) {
		this.paymentNotificationDays = paymentNotificationDays;
	}

	public String getSmsNotificationNo() {
		return smsNotificationNo;
	}

	public void setSmsNotificationNo(String smsNotificationNo) {
		this.smsNotificationNo = smsNotificationNo;
	}

	public String getEmailNotification() {
		return emailNotification;
	}

	public void setEmailNotification(String emailNotification) {
		this.emailNotification = emailNotification;
	}

	public List<AccountBalance> getAccountBalances() {
		return accountBalances;
	}

	public void setAccountBalances(List<AccountBalance> accountBalances) {
		this.accountBalances = accountBalances;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AccountInfo [accountid=" + accountid + ", name=" + name + ", status=" + status + ", partner=" + partner
				+ ", autoPayment=" + autoPayment + ", accountNumber=" + accountNumber + ", bankName=" + bankName
				+ ", routingnumber=" + routingnumber + ", paymentNotificationDays=" + paymentNotificationDays
				+ ", smsNotificationNo=" + smsNotificationNo + ", emailNotification=" + emailNotification
				+ ", transactions=" + transactions + ", accountBalances=" + accountBalances + ", getAccountid()="
				+ getAccountid() + ", getName()=" + getName() + ", getStatus()=" + getStatus() + ", getPartner()="
				+ getPartner() + ", getAutoPayment()=" + getAutoPayment() + ", getAccountNumber()=" + getAccountNumber()
				+ ", getBankName()=" + getBankName() + ", getRoutingnumber()=" + getRoutingnumber()
				+ ", getTransactions()=" + getTransactions() + ", getPaymentNotificationDays()="
				+ getPaymentNotificationDays() + ", getSmsNotificationNo()=" + getSmsNotificationNo()
				+ ", getEmailNotification()=" + getEmailNotification() + ", getAccountBalances()="
				+ getAccountBalances() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	

}
