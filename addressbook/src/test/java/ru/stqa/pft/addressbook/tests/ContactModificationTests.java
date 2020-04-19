package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() throws Exception {
    app.getContactHelper().modificationContact();
    app.getContactHelper().fillContactForm(new ContactData
            ("FirstName2", "LastName2", "Address2", "Phone2", "Email2"));
    app.getContactHelper().submitModificationContact();
    //try{Thread.sleep(100);}  catch (Exception e){}//пауза
    app.getContactHelper().returnToHomePage();
  }
}
