package com.lawoffice;

import com.lawoffice.exception.LawyerNotFoundException;
import com.lawoffice.exception.UnableToRegisterCase;

public interface ILawOffice {

  public void registerLawyer(Lawyer lawyer);

  public void registerJudge(Judge judge);

  public Lawyer findDefenceAttorney(LawyerTypes speciality) throws LawyerNotFoundException;

  public Case registerCaseWithLawyer(Lawyer lawyer, Defendant defendant)
      throws UnableToRegisterCase;

  public void assignJudgeToCase(Case cas);

  public void assignProsecutorToCase(Case cas);

  public void assignHearingDate(Case cas);

  public void hearingProceedings(Case cas);

  public void verdict(Case cas);

  public void getAllLawyerDetails();


}
