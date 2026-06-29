package com.pgs.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
    final DynamicTablePage.TableHeaders headers = dtPage.getTableHeadersText();
    Assert.assertEquals(headers.superhero(), "SUPERHERO");
    Assert.assertEquals(headers.status(), "STATUS");
    Assert.assertEquals(headers.realName(), "REAL NAME");
  }

  @Test
  public void peterParkerIsPresent() {
    DynamicTablePage dtPage = new DynamicTablePage(driver);
    dtPage.open();
    final WebElement row = dtPage.rowByText("Spider-Man");
    Assert.assertTrue(row.getText().contains("Peter Parker"));
  }
}
