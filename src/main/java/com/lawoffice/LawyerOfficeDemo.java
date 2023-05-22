package com.lawoffice;

import java.time.LocalDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import com.homework.util.Util;
import com.lawoffice.exception.LawyerNotFoundException;
import com.lawoffice.exception.UnableToRegisterCase;

public class LawyerOfficeDemo {

  private static final Logger logger = LogManager.getLogger(LawyerOfficeDemo.class);

  public static void main(String[] args) {

    Configurator.initialize(null, "log4j2.xml");

    // Register list of lawyers to law office
    ILawOffice lawOffice = new LawOffice();
    registerLawyersToLawOffice(lawOffice);
    registerJudgesToLawOffice(lawOffice);


    // Create Defedant
    IRecordEventDate crimeDate = () -> LocalDate.now().toString();
    Defendant defedant =
        new Defendant("Peter Frank", 35, crimeDate.recordEventDate(), "Hit and Run case");
    ILog.logToConsole("Defendant Details =========");
    ILog.logToConsole(defedant.toString());

    // Defendant get to see all lawyer details
    lawOffice.getAllLawyerDetails();

    // Defendant finds a Criminal Lawyer
    LawyerTypes specialityType = LawyerTypes.CRIMINAL_LAWYER;
    Lawyer myLawyer = null;
    try {
      myLawyer = lawOffice.findDefenceAttorney(specialityType);
    } catch (LawyerNotFoundException exception) {
      logger.error("Sorry no lawyer available, please try again later..");
      return;
    }

    if (myLawyer == null) {
      ILog.logToConsole("Sorry, No " + specialityType
          + " lawyer available at our office. Please look for another office");
      return;
    }

    // If a lawyer found, then Hire a Criminal Lawyer and register a case
    Case myCase = null;
    try {
      myCase = lawOffice.registerCaseWithLawyer(myLawyer, defedant);
    } catch (UnableToRegisterCase exception) {
      logger.error("Unable to register Case due to some error");
      return;
    }

    ILog.logToConsole("\nMy Registered case details");
    ILog.logToConsole(myCase.toString());

    // Discuss case with Lawyer
    myLawyer.discussCaseWithDefendant(myCase);
    ILog.logToConsole("\nCase details after discussion with Lawyer");
    ILog.logToConsole(myCase.toString());

    // Judge assigned to Case
    lawOffice.assignProsecutorToCase(myCase);
    ILog.logToConsole("\nCase details after Prosecutor allocation");
    ILog.logToConsole(myCase.toString());

    // Judge assigned to Case
    lawOffice.assignJudgeToCase(myCase);
    ILog.logToConsole("\nCase details after Judge allocation");
    ILog.logToConsole(myCase.toString());

    // Assign a hearing date
    IRecordEventDate heardingDate = () -> LocalDate.now().plusDays(10).toString();
    // lawOffice.assignHearingDate(myCase);
    myCase.setHearingDate(heardingDate.recordEventDate());
    ILog.logToConsole("\nCase details after hearing date");
    ILog.logToConsole(myCase.toString());


    // Defendant pleads not guilty
    myCase.setPleadGuilty(false);
    ILog.logToConsole("\nCase details after defendant Pleads not guilty");
    ILog.logToConsole(myCase.toString());

    // Hearing day proceedings
    lawOffice.hearingProceedings(myCase);
    ILog.logToConsole("\nCase details after Hearing");
    ILog.logToConsole(myCase.toString());


    // Judge provides final verdict
    lawOffice.verdict(myCase);
    ILog.logToConsole("\nFinal Verdict on the Case");
    ILog.logToConsole(myCase.toString());


    Class<?> clazz = LawyerOfficeDemo.class; // Replace with your desired class

    int methodCount = Util.getMethodCount(clazz);
    System.out.println("Number of methods: " + methodCount);

    int instanceVariableCount = Util.getInstanceVariableCount(clazz);
    System.out.println("Number of instance variables: " + instanceVariableCount);

  }

  private static void registerLawyersToLawOffice(ILawOffice lawOffice) {

    // Register Lawyers
    Lawyer criminalLaywer1 = new DefenceAttorney();
    criminalLaywer1.setName("Mike Rotham");
    criminalLaywer1.setSpecialty(LawyerTypes.CRIMINAL_LAWYER);
    criminalLaywer1.setYearsOfExperience(15);
    criminalLaywer1.setGender("Male");

    Lawyer corporateLaywer = new DefenceAttorney();
    corporateLaywer.setName("Peter Frank");
    corporateLaywer.setSpecialty(LawyerTypes.CORPORATE_LAWYER);
    corporateLaywer.setYearsOfExperience(10);
    corporateLaywer.setGender("Male");

    Lawyer immigration = new DefenceAttorney();
    immigration.setName("Nikki Forlani");
    immigration.setSpecialty(LawyerTypes.IMMIGRATION_LAWYER);
    immigration.setYearsOfExperience(18);
    immigration.setGender("Female");

    // Create object of Law Office
    lawOffice.registerLawyer(criminalLaywer1);
    lawOffice.registerLawyer(corporateLaywer);
    lawOffice.registerLawyer(immigration);

  }

  private static void registerJudgesToLawOffice(ILawOffice lawOffice) {

    // Register Judges
    Judge judge1 = new Judge();
    judge1.setName("Kevin Peter");
    judge1.setSpecialty(LawyerTypes.CRIMINAL_LAWYER);
    judge1.setYearsOfExperience(17);
    judge1.setGender("Male");

    Judge judge2 = new Judge();
    judge2.setName("Mr Bean");
    judge2.setSpecialty(LawyerTypes.CORPORATE_LAWYER);
    judge2.setYearsOfExperience(21);
    judge2.setGender("Male");

    // Create object of Law Office
    lawOffice.registerJudge(judge1);
    lawOffice.registerJudge(judge2);

  }



}
