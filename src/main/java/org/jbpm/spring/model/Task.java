package org.jbpm.spring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class Task implements Serializable
{
  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  private Long id;
  private String name;
  private String status;
  private String description;
  private String actualOwnerId;
  private Date createdOn;
  private Long caseId;
  private Map<String,Object> data;
  

  public Task() {
	super();
	// TODO Auto-generated constructor stub
}



public Task(Long id, String name, String status, String description,
		String actualOwnerId, Date createdOn, Long caseId) {
	super();
	this.id = id;
	this.name = name;
	this.status = status;
	this.description = description;
	this.actualOwnerId = actualOwnerId;
	this.createdOn = createdOn;
	this.caseId = caseId;
}



public String getStatus() {
    return this.status;
  }

  public String getName() {
    return this.name;
  }



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getDescription() {
	return description;
}



public void setDescription(String description) {
	this.description = description;
}



public String getActualOwnerId() {
	return actualOwnerId;
}



public void setActualOwnerId(String actualOwnerId) {
	this.actualOwnerId = actualOwnerId;
}



public Date getCreatedOn() {
	return createdOn;
}



public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
}



public void setName(String name) {
	this.name = name;
}



public void setStatus(String status) {
	this.status = status;
}

public Long getCaseId() {
	return caseId;
}



public void setCaseId(Long caseId) {
	this.caseId = caseId;
}



public Map<String, Object> getData() {
	return data;
}

public void setData(Map<String, Object> data) {
	this.data = data;
}



@Override
public String toString() {
	return "Task [id=" + id + ", name=" + name + ", status=" + status
			+ ", description=" + description + ", actualOwnerId="
			+ actualOwnerId + ", createdOn=" + createdOn + ", caseId=" + caseId
			+ ", data=" + data + "]";
}


}