package org.jbpm.spring.model;

import java.util.Collection;

public class Case
{
  private String id;
  private Patient patient;
  private Collection<Task> taskList;

  public Case()
  {
  }

  public Case(String id, Patient patient, Collection<Task> taskList)
  {
    this.id = id;
    this.patient = patient;
    this.taskList = taskList;
  }

  public String getId() {
    return this.id;
  }

  public Patient getPatient() {
    return this.patient;
  }

  public Collection<Task> getTaskList() {
    return this.taskList;
  }

  public String toString()
  {
    return "Case [id=" + this.id + ", patient=" + this.patient + ", taskList=" + 
      this.taskList + "]";
  }
}