package org.jbpm.spring.model;

import java.io.Serializable;

public class SlackMessage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private String user;
	private String imageUrl;
	private String date;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "SlackMessage [message=" + message + ", user=" + user + ", imageUrl=" + imageUrl + ", date=" + date
				+ "]";
	}
	
	

}
