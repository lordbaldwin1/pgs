package com.pgs.config;

public final class AppConfig {

  private AppConfig() {}

  public static String baseUrl() {
    return System.getProperty("baseUrl", "https://qaplayground.dev");
  }

  public static boolean headless() {
    return Boolean.parseBoolean(System.getProperty("headless", "true"));
  }

  public static String browser() {
    return System.getProperty("browser", "chrome");
  }

  public static long implicitWaitSeconds() {
    return Long.parseLong(System.getProperty("implicitWaitSeconds", "5"));
  }
}
