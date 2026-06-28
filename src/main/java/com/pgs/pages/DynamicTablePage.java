package com.pgs.pages;

import org.openqa.selenium.WebDriver;

import com.pgs.config.AppConfig;

public class DynamicTablePage extends BasePage {
  

  public DynamicTablePage(WebDriver driver) {
    super(driver);
  }

  public DynamicTablePage open() {
    driver.get(AppConfig.baseUrl() + "/apps/dynamic-table");
    return this;
  }
}
