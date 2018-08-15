package org.jbpm.spring.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
@Service

public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String type;
	
	private double amount;
	
	private String status ;
	
	private Date lastUpdatedDate;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	@Override
	public String toString() {
		return "Account [type=" + type + ", amount=" + amount + ", status="
				+ status + ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}
	

}
