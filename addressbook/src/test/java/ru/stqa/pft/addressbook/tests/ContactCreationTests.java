package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests  extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().createContact(new ContactData("FirstName1",
            "LastName1", null, null, null, "Group1"), true);
    app.getNavigationHelper().gotoHomePage();
  }
}
