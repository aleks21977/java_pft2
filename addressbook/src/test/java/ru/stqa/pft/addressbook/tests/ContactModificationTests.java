package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.HelperBase;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  public Object ContactData;

  @Test
  public void testContactModification() throws Exception {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("FirstName1",
              "LastName1", null, null, null, "Group1"), true);
//      app.getNavigationHelper().gotoHomePage();

    }
    List<ContactData> before = app.getContactHelper().getContactList();
//    System.out.println(before);
    app.getContactHelper().modificationContact(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "FirstName2", "LastName2",
            "Address2", "Phone2", "Email2", null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitModificationContact();
    //try{Thread.sleep(100);}  catch (Exception e){}//пауза
//    app.getNavigationHelper().gotoHomePage();
    app.getHelperBase().gotoHomePage();
    try{Thread.sleep(1000);}  catch (Exception e){}//пауза
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));

  }
}
