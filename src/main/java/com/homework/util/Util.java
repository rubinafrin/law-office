package com.homework.util;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class Util {

  public static String getProjectRoot(Class<?> clazz) {
    Path currentPath = Paths.get(clazz.getResource("").getPath());
    Path projectRoot = currentPath;

    while (projectRoot.getParent() != null && !projectRoot.endsWith("com")) {
      projectRoot = projectRoot.getParent();
    }

    return projectRoot.toString();
  }

  public static Set<String> findInterfaces(String directory) {
    Set<String> interfaces = new HashSet<>();
    try {
      File dir = new File(directory);
      File[] files = dir.listFiles();

      for (File file : files) {
        System.out.println(file.getName());
        if (file.isDirectory()) {
          interfaces.addAll(findInterfaces(file.getAbsolutePath()));
          System.out.println("file.getAbsolutePath()" + file.getAbsolutePath());
        } else if (file.getName().endsWith(".class")) {
          String className = file.getAbsolutePath().replace(directory, "")
              .replace(File.separator, "").replace(".class", "");
          Class<?> clazz = Class.forName(className);
          if (clazz.isInterface()) {
            interfaces.add(className);
          }
        }
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      // System.out.println("Some error occured, while finding number of interfaces");
    }

    return interfaces;
  }

  public static int getMethodCount(Class<?> clazz) {
    Method[] methods = clazz.getDeclaredMethods();
    return methods.length;
  }

  public static int getInstanceVariableCount(Class<?> clazz) {
    Field[] fields = clazz.getDeclaredFields();
    return fields.length;
  }

}
