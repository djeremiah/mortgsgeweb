package org.jbpm.spring.model;

import java.io.Serializable;
import java.util.List;

public class MortgageDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String yrsofamortization;
	private String downpayment;
	private String annualincome;
	private String ssn;
	private String ageofproperty;
	private String saleprice;
	private String locale;
	private String addressofproperty;
	
	List<Activity> activities;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYrsofamortization() {
		return yrsofamortization;
	}
	public void setYrsofamortization(String yrsofamortization) {
		this.yrsofamortization = yrsofamortization;
	}
	public String getDownpayment() {
		return downpayment;
	}
	public void setDownpayment(String downpayment) {
		this.downpayment = downpayment;
	}
	public String getAnnualincome() {
		return annualincome;
	}
	public void setAnnualincome(String annualincome) {
		this.annualincome = annualincome;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getAgeofproperty() {
		return ageofproperty;
	}
	public void setAgeofproperty(String ageofproperty) {
		this.ageofproperty = ageofproperty;
	}
	public String getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(String saleprice) {
		this.saleprice = saleprice;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getAddressofproperty() {
		return addressofproperty;
	}
	public void setAddressofproperty(String addressofproperty) {
		this.addressofproperty = addressofproperty;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<Activity> getActivities() {
		return activities;
	}
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	@Override
	public String toString() {
		return "MortgageDetail [name=" + name + ", yrsofamortization=" + yrsofamortization + ", downpayment="
				+ downpayment + ", annualincome=" + annualincome + ", ssn=" + ssn + ", ageofproperty=" + ageofproperty
				+ ", saleprice=" + saleprice + ", locale=" + locale + ", addressofproperty=" + addressofproperty + "]";
	}
	
	
}
