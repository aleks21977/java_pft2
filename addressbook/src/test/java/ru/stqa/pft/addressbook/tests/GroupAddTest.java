package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class GroupAddTest extends TestBase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();



  @Test
  public void testGroupAdd() {
    driver.findElement(By.id("205")).click();
    driver.findElement(By.name("to_group")).click();
    new Select(driver.findElement(By.name("to_group"))).selectByVisibleText("Group1");
    driver.findElement(By.name("to_group")).click();
    driver.findElement(By.name("add")).click();
    driver.findElement(By.linkText("home")).click();
  }
}
