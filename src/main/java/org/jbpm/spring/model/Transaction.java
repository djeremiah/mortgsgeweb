package org.jbpm.spring.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private String transactionId;
	
	@Column(name="accountid")
	private String accountid;
	
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="accountid")
	private AccountInfo accountInfo;*/
	
	@Column(name="merchantname")
	private String merchantName;
	
	@Column(name="transdate")
	private Date transactionDate;
	
	@Column(name="transamount")
	private BigDecimal transactionAmont;
	
	@Column(name="address")
	private String address;
	
	@Column(name="channel")
	private String channel;

	@Column(name="parntername")
	private String parnterName;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getTransactionAmont() {
		return transactionAmont;
	}

	public void setTransactionAmont(BigDecimal transactionAmont) {
		this.transactionAmont = transactionAmont;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getParnterName() {
		return parnterName;
	}

	public void setParnterName(String parnterName) {
		this.parnterName = parnterName;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountid=" + accountid + ", merchantName="
				+ merchantName + ", transactionDate=" + transactionDate + ", transactionAmont=" + transactionAmont
				+ ", address=" + address + ", channel=" + channel + ", parnterName=" + parnterName + "]";
	}

	
	

}
