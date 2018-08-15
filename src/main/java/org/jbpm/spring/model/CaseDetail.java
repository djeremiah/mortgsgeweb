package org.jbpm.spring.model;

import java.io.Serializable;
import java.util.List;

public class CaseDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long processId;
	private String caseId;
	private Customer customer;
	private List<Account> accounts;
	private List<ActionItems> actionItems;
	private List<ActionItems> actionItemsInprogress;
	private List<Roles> caseRoles;
	private List<Users> caseUsers;
	private List<Task> tasks;
	
	
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
	
	
	public List<ActionItems> getActionItems() {
		return actionItems;
	}
	public void setActionItems(List<ActionItems> actionItems) {
		this.actionItems = actionItems;
	}
	public List<ActionItems> getActionItemsInprogress() {
		return actionItemsInprogress;
	}
	public void setActionItemsInprogress(List<ActionItems> actionItemsInprogress) {
		this.actionItemsInprogress = actionItemsInprogress;
	}
	public List<Roles> getCaseRoles() {
		return caseRoles;
	}
	public void setCaseRoles(List<Roles> caseRoles) {
		this.caseRoles = caseRoles;
	}
	public List<Users> getCaseUsers() {
		return caseUsers;
	}
	public void setCaseUsers(List<Users> caseUsers) {
		this.caseUsers = caseUsers;
	}
	public long getProcessId() {
		return processId;
	}
	public void setProcessId(long processId) {
		this.processId = processId;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	@Override
	public String toString() {
		return "CaseDetail [processId=" + processId + ", caseId=" + caseId
				+ ", customer=" + customer + ", accounts=" + accounts
				+ ", actionItems=" + actionItems + ", actionItemsInprogress="
				+ actionItemsInprogress + ", caseRoles=" + caseRoles
				+ ", caseUsers=" + caseUsers + ", tasks=" + tasks + "]";
	}
	
	

}
