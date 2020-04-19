package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.TestBase;

public class ContactCreationTests  extends TestBase {
//  private WebDriver driver;
//  private boolean acceptNextAlert = true;
//  private StringBuffer verificationErrors = new StringBuffer();

//  @BeforeClass(alwaysRun = true)
//  public void setUp() throws Exception {
//    driver = new FirefoxDriver();
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//  }

  @Test
  public void testContactCreation() throws Exception {
//    driver.get("http://localhost/addressbook/");
//    driver.findElement(By.name("user")).click();
//    driver.findElement(By.name("user")).clear();
//    driver.findElement(By.name("user")).sendKeys("admin");
//    driver.findElement(By.name("pass")).click();
//    driver.findElement(By.name("pass")).clear();
//    driver.findElement(By.name("pass")).sendKeys("secret");
//    driver.findElement(By.xpath("//input[@value='Login']")).click();

    app.getNavigationHelper().gotoGroupPage();


    driver.findElement(By.linkText("add new")).click();
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("FirstName1");
    driver.findElement(By.name("lastname")).click();
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("LastName1");
    driver.findElement(By.name("address")).click();
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys("address1");
    driver.findElement(By.name("home")).click();
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys("+79876543211");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("email1@mail.com");

    driver.findElement(By.xpath("(//input[@name='submit'])")).click();
    driver.findElement(By.linkText("home page")).click();
  }

//  @AfterClass(alwaysRun = true)
//  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
//  }
}
