package org.jbpm.spring.model;

public class Patient
{
  private String name;
  private String age;
  private String address;

  public Patient()
  {
  }

  public Patient(String name, String age, String address)
  {
    this.name = name;
    this.age = age;
    this.address = address;
  }

  public String getName() {
    return this.name;
  }

  public String getAge() {
    return this.age;
  }

  public String getAddress() {
    return this.address;
  }
}