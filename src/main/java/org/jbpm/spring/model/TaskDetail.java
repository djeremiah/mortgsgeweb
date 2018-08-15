package org.jbpm.spring.model;

import java.io.Serializable;
import java.util.List;

public class TaskDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Task> taskList;

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	@Override
	public String toString() {
		return "TaskDetail [taskList=" + taskList + "]";
	}
	
	
	
	

}
