package com.pgs.tests;

import com.pgs.config.AppConfig;
import com.pgs.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExampleTest {

  private WebDriver driver;

  @BeforeMethod
  public void setUp() {
    driver = DriverFactory.createDriver();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Test
  public void loadsConfiguredPage() {
    driver.get(AppConfig.baseUrl());

    WebElement heading = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

    Assert.assertFalse(heading.getText().isBlank(), "Page heading should not be empty");
  }
}
