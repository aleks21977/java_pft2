package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.HelperBase;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() throws Exception {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("FirstName1",
              "LastName1", null, null, null, "Group1"), true);
//      app.getNavigationHelper().gotoHomePage();

    }
    app.getContactHelper().modificationContact();
    app.getContactHelper().fillContactForm(new ContactData("FirstName2", "LastName2",
            "Address2", "Phone2", "Email2", null), false);
    app.getContactHelper().submitModificationContact();
    //try{Thread.sleep(100);}  catch (Exception e){}//пауза
//    app.getNavigationHelper().gotoHomePage();
    app.getHelperBase().gotoHomePage();
    try{Thread.sleep(1000);}  catch (Exception e){}//пауза
  }
}
