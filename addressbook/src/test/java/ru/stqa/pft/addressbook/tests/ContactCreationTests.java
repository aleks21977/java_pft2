package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests  extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData
            ("FirstName1", "LastName1", null, null, null));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    System.out.println("1");
  }
}
