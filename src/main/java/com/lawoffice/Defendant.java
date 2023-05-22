package com.lawoffice;

public class Defendant {

  private String name;
  private int age;
  private String crimeDetails;
  private String crimeDate;

  public Defendant(String name, int age, String crimeDate, String crimeDetails) {
    this.name = name;
    this.age = age;
    this.crimeDate = crimeDate;
    this.crimeDetails = crimeDetails;

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }



  public void setAge(int age) {
    this.age = age;
  }



  public String getCrimeDetails() {
    return crimeDetails;
  }

  public void setCrimeDetails(String crimeDetails) {
    this.crimeDetails = crimeDetails;
  }

  public String getCrimeDate() {
    return crimeDate;
  }

  public void setCrimeDate(String crimeDate) {
    this.crimeDate = crimeDate;
  }

  @Override
  public String toString() {
    return "Defendant [name=" + name + ", age=" + age + ", crimeDetails=" + crimeDetails
        + ", crimeDate=" + crimeDate + "]";
  }

}
