package com.lawoffice;

import java.util.Date;

public interface ILog {



  public static void logToConsole(String data) {
    System.out.println(new Date() + ": " + data);
  }

}
