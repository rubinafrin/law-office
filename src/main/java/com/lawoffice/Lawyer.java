package com.lawoffice;

public abstract class Lawyer {

  private String name;
  private int yearsOfExperience;
  private LawyerTypes specialty;
  private String gender;

  public void discussCaseWithDefendant(Case cas) {
    // Update case findings and Lawyer arguments based on discussion
    cas.setLawyerRemarks("Case details updated with all evidences");

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getYearsOfExperience() {
    return yearsOfExperience;
  }

  public void setYearsOfExperience(int yearsOfExperience) {
    this.yearsOfExperience = yearsOfExperience;
  }

  public LawyerTypes getSpecialty() {
    return specialty;
  }

  public void setSpecialty(LawyerTypes specialty) {
    this.specialty = specialty;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "Lawyer [name=" + name + ", yearsOfExperience=" + yearsOfExperience + ", specialty="
        + specialty + ", gender=" + gender + "]";
  }



}
