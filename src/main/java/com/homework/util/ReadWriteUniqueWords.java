package com.homework.util;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class ReadWriteUniqueWords {

  public static void main(String[] args) {
    String fileName = "mothersday.txt";
    ClassLoader classLoader = ReadWriteUniqueWords.class.getClassLoader();
    File file = new File(classLoader.getResource(fileName).getFile());



    try {
      String fileContents = FileUtils.readFileToString(file, "UTF-8");
      String[] words = StringUtils.split(fileContents, " ");

      long totalWords = words.length;

      Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

      long uniqueCount = uniqueWords.size();

      System.out.println("Total words in file: " + totalWords);
      System.out.println("Number of unique words in file: " + uniqueCount);
    } catch (Exception e) {
      System.out.println("Error reading file: " + e.getMessage());
    }
  }

}
