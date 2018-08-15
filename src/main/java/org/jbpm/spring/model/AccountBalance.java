package org.jbpm.spring.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="accountbalance")
public class AccountBalance implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue 
	@Column(name="id")
	private Integer id;
	
	@Column(name="accountid")
	private String accountid;
	
	@Column(name="type")
	private String type;
	
	@Column(name="description")
	private String description;
	
	@Column(name="code")
	private String code;
	
	@Column(name="startdate")
	private Date startDate;
	
	@Column(name="enddate")
	private Date endDate;
	
	@Column(name="duedate")
	private Date dueDate;
	
	@Column(name="payscheduledate")
	private Date payScheduleDate;
	
	@Column(name="balanceamount")
	private BigDecimal totalBalanceAmount;
	
	@Column(name="minbalanceamount")
	private BigDecimal minBalanceAmount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getTotalBalanceAmount() {
		return totalBalanceAmount;
	}

	public void setTotalBalanceAmount(BigDecimal totalBalanceAmount) {
		this.totalBalanceAmount = totalBalanceAmount;
	}

	public BigDecimal getMinBalanceAmount() {
		return minBalanceAmount;
	}

	public void setMinBalanceAmount(BigDecimal minBalanceAmount) {
		this.minBalanceAmount = minBalanceAmount;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getPayScheduleDate() {
		return payScheduleDate;
	}

	public void setPayScheduleDate(Date payScheduleDate) {
		this.payScheduleDate = payScheduleDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "AccountBalance [id=" + id + ", accountid=" + accountid + ", type=" + type + ", description="
				+ description + ", code=" + code + ", startDate=" + startDate + ", endDate=" + endDate + ", dueDate="
				+ dueDate + ", payScheduleDate=" + payScheduleDate + ", totalBalanceAmount=" + totalBalanceAmount
				+ ", minBalanceAmount=" + minBalanceAmount + "]";
	}


}
