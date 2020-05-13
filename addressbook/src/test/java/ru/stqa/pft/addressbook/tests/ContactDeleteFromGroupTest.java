package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeleteFromGroupTest extends TestBase{

    File photo = new File("src/test/resources/stru.png");

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0){
            app.goTo().gotoHomePage();
            app.contact().create(new ContactData().withFirstName("FirstName1").withLastName("LastName1")
                    .withPhoto(photo), true);
        }
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("Group0"));
        }
    }

    @Test
    public void testContactDeleteFromGroup() {
        Contacts listContacts = app.db().contacts();
        ContactData selectedContact = listContacts.iterator().next();
        Groups listGroups = app.db().groups();
        GroupData selectedGroup = listGroups.iterator().next();
        app.goTo().gotoHomePage();
        if (selectedContact.getGroups().isEmpty() || !selectedContact.getGroups().contains(selectedGroup)) {
            app.contact().selectDisplayGroup("[all]");
            app.contact().addContactToGroup(selectedContact,selectedGroup);
            assertThat(selectedContact.getGroups().withAdded(selectedGroup), CoreMatchers.equalTo(app.db().contacts().stream().
                    filter((a)->a.getId() == selectedContact.getId()).collect(Collectors.toList()).get(0).getGroups()));
            app.goTo().gotoHomePage();
        }
        app.contact().removeContactFromGroup(selectedContact, selectedGroup);
        app.goTo().gotoHomePage();
        app.contact().selectDisplayGroup("[all]");
        assertThat(selectedContact.getGroups().without(selectedGroup), CoreMatchers.equalTo(app.db().contacts().stream().
                filter((a)->a.getId() == selectedContact.getId()).collect(Collectors.toList()).get(0).getGroups()));
    }



}