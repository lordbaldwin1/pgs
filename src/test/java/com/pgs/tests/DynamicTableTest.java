package com.pgs.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pgs.driver.DriverFactory;
import com.pgs.pages.DynamicTablePage;

public class DynamicTableTest {
  
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
  public void pageLoads() {
    DynamicTablePage dtPage = new DynamicTablePage(driver);
    dtPage.open();
  }
}
