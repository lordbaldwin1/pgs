package com.pgs.driver;

import com.pgs.config.AppConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class DriverFactory {

  private DriverFactory() {
  }

  public static WebDriver createDriver() {
    WebDriverManager.chromedriver().setup();

    ChromeOptions options = new ChromeOptions();
    if (AppConfig.headless()) {
      options.addArguments("--headless=new");
    }
    options.addArguments("--no-sandbox", "--disable-dev-shm-usage");

    WebDriver driver = new ChromeDriver(options);
    return driver;
  }
}
