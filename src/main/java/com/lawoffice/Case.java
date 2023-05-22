package com.lawoffice;

import java.util.Date;

public class Case implements ICaseLog {

  private int caseNumber;
  private Defendant defendant;
  private Lawyer lawyer;
  private String lawyerRemarks;
  private boolean isPleadGuilty;
  private String hearingDate;
  private Judge judge;
  private String verdict;
  private Prosecutor prosecutor;
  private String hearingDetails;

  public int getCaseNumber() {
    return caseNumber;
  }

  public void setCaseNumber(int caseNumber) {
    this.caseNumber = caseNumber;
  }

  public Defendant getDefendant() {
    return defendant;
  }

  public void setDefendant(Defendant defendant) {
    this.defendant = defendant;
  }

  public Lawyer getLawyer() {
    return lawyer;
  }

  public void setLawyer(Lawyer lawyer) {
    this.lawyer = lawyer;
  }

  public String getLawyerRemarks() {
    return lawyerRemarks;
  }

  public void setLawyerRemarks(String lawyerRemarks) {
    this.lawyerRemarks = lawyerRemarks;
  }



  public boolean isPleadGuilty() {
    return isPleadGuilty;
  }

  public void setPleadGuilty(boolean isPleadGuilty) {
    this.isPleadGuilty = isPleadGuilty;
  }

  public String getVerdict() {
    return verdict;
  }

  public void setVerdict(String verdict) {
    this.verdict = verdict;
  }

  public String getHearingDate() {
    return hearingDate;
  }

  public void setHearingDate(String hearingDate) {
    this.hearingDate = hearingDate;
  }

  public Judge getJudge() {
    return judge;
  }

  public void setJudge(Judge judge) {
    this.judge = judge;
  }

  public Prosecutor getProsecutor() {
    return prosecutor;
  }

  public void setProsecutor(Prosecutor prosecutor) {
    this.prosecutor = prosecutor;
  }

  public String getHearingDetails() {
    return hearingDetails;
  }

  public void setHearingDetails(String hearingDetails) {
    this.hearingDetails = hearingDetails;
  }

  @Override
  public String toString() {
    return "Case [caseNumber=" + caseNumber + ", defendant=" + defendant + ", lawyer=" + lawyer
        + ", lawyerRemarks=" + lawyerRemarks + ", isPleadGuilty=" + isPleadGuilty + ", hearingDate="
        + hearingDate + ", judge=" + judge + ", verdict=" + verdict + ", prosecutor=" + prosecutor
        + "]";
  }

  @Override
  public void recordActivity(String activity) {

    ILog.logToConsole(new Date() + ": " + activity);

  }


}
