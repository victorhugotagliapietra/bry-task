package com.brytask.util;

public class DataMaskingUtil {

  public static String maskCpf(String cpf) {
    return cpf.substring(0, 3) + "*****" + cpf.substring(8);
  }
}
