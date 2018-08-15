package org.jbpm.spring.model;

import java.io.Serializable;

public class Roles implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String roleId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + "]";
	}
	
	
}
