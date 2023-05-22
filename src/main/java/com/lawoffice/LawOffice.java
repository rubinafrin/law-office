package com.lawoffice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.lawoffice.exception.LawyerNotFoundException;
import com.lawoffice.exception.UnableToRegisterCase;

public class LawOffice implements ILawOffice {

  private static final Logger logger = LogManager.getLogger(LawOffice.class);

  private String practiceName;
  private List<Lawyer> lawyers = new ArrayList<>();
  private List<Judge> judges = new LinkedList<>();
  private CustomLinkedList<Case> caseFile = new CustomLinkedList<>();

  @Override
  public void registerLawyer(Lawyer lawyer) {
    this.lawyers.add(lawyer);
  }

  @Override
  public void registerJudge(Judge judge) {
    this.judges.add(judge);
  }

  /*
   * Find the Lawyer by its first occurrence
   */
  @Override
  public Lawyer findDefenceAttorney(LawyerTypes speciality) throws LawyerNotFoundException {

    logger.debug("Invoking function findDefenceAttorney");

    Optional<Lawyer> foundLawyer =
        lawyers.stream().filter(lawyer -> lawyer.getSpecialty() == speciality).findFirst();

    Lawyer lawyer = foundLawyer.orElse(null);

    if (lawyer == null)
      throw new LawyerNotFoundException("No " + speciality + " attorney available");

    return lawyer;
  }

  @Override
  public Case registerCaseWithLawyer(Lawyer lawyer, Defendant defendant)
      throws UnableToRegisterCase {

    logger.debug("Invoking function registerCaseWithLawyer");

    if (lawyer == null || defendant == null) {
      throw new UnableToRegisterCase("Some issue occured, system cannot register the case");
    }

    Case cas = new Case();
    cas.setCaseNumber(caseFile.size() + 1);
    cas.setDefendant(defendant);
    cas.setLawyer(lawyer);

    caseFile.addLast(cas);

    return cas;

  }

  @Override
  public void assignJudgeToCase(Case cas) {

    logger.debug("Invoking function assignJudgeToCase");

    // Create a new Judge object
    Judge judge = new Judge();
    judge.setName("Ian Joseph");
    judge.setYearsOfExperience(22);

    cas.setJudge(judge);

  }

  @Override
  public void assignProsecutorToCase(Case cas) {

    logger.debug("Invoking function assignProsecutorToCase");

    // Create a new Prosecutor object
    Prosecutor prosecutor = new Prosecutor();
    prosecutor.setName("John Dan");
    prosecutor.setYearsOfExperience(12);
    cas.setProsecutor(prosecutor);

  }

  @Override
  public void assignHearingDate(Case cas) {
    cas.setHearingDate("04/10/2023");
  }

  @Override
  public void hearingProceedings(Case cas) {

    logger.debug("Invoking function hearingProceedings");

    cas.setHearingDetails(
        "Defendant Laywer and Prosecutor put forwards all their arguments and witeness");

    logger.debug("Defendant Laywer and Prosecutor put forwards all their arguments and witeness");
  }

  @Override
  public void verdict(Case cas) {
    logger.debug("Judge goes through all evidences and arguments from both sides");
    // Makes final verdict Defendant as not guilty
    cas.setVerdict("Not Guilty");

  }

  public String getPracticeName() {
    return practiceName;
  }

  public void setPracticeName(String practiceName) {
    this.practiceName = practiceName;
  }

  public List getLawyers() {
    return lawyers;
  }

  public void setLawyers(List lawyers) {
    this.lawyers = lawyers;
  }

  @Override
  public void getAllLawyerDetails() {

    System.out.println("Lawyers List******************");
    System.out.println(lawyers);

    // for (int i = 0; i < lawyers.size(); i++) {
    //
    // Lawyer lawyer = (Lawyer) lawyers.get(i);
    //
    // System.out.println("============================");
    // System.out.println(lawyer.getName());
    // System.out.println(lawyer.getSpecialty());
    // System.out.println(lawyer.getYearsOfExperience());
    // System.out.println(lawyer.getGender());
    // }

  }



}
