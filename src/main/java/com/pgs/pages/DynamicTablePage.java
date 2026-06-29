package com.pgs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pgs.config.AppConfig;

public class DynamicTablePage extends BasePage {

  public record TableHeaders(String superhero, String status, String realName) {
  }

  private final By superheroHeading = By.xpath("//th[normalize-space()='Superhero']");
  private final By statusHeading = By.xpath("//th[normalize-space()='Status']");
  private final By realNameHeading = By.xpath("//th[normalize-space()='Real Name']");

  public DynamicTablePage(WebDriver driver) {
    super(driver);
  }

  public DynamicTablePage open() {
    driver.get(AppConfig.baseUrl() + "/apps/dynamic-table");
    return this;
  }

  public WebElement rowByText(String text) {
    return waitForVisible(By.xpath("//tr[td[contains(normalize-space(), '%s')]]".formatted(text)));
  }

  public TableHeaders getTableHeadersText() {
    return new TableHeaders(
        waitForVisible(superheroHeading).getText(),
        waitForVisible(statusHeading).getText(),
        waitForVisible(realNameHeading).getText());
  }
}
