package org.jbpm.spring.model;

import java.io.Serializable;
import java.util.List;

public class CustomerOnboarding implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private Account account;
	private List<Account> accounts ;
	private List<String> roles ;
	private List<String> users ;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public List<String> getUsers() {
		return users;
	}
	public void setUsers(List<String> users) {
		this.users = users;
	}
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "CustomerOnboarding [customer=" + customer + ", account="
				+ account + ", accounts=" + accounts + ", roles=" + roles
				+ ", users=" + users + "]";
	}
	
	
	
	

}
