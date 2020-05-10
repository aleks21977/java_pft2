package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstName("FirstName1").withLastName("LastName1").withGroup("Group1"), true);
    }
  }

  @Test
  public void testContactDeletion() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    try{Thread.sleep(100);}  catch (Exception e){}//пауза
//    app.getNavigationHelper().gotoHomePage();
    app.getHelperBase().gotoHomePage();
    try{Thread.sleep(1000);}  catch (Exception e){}//пауза
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);//в l5_m3 на 05:35 сказано что не нужно тут менять before.size() - 1

    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
