package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests  extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromCsv() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")))) {
      String line = reader.readLine();
      while (line != null) {
        String[] split = line.split(";");
        list.add(new Object[] {new ContactData().withFirstName(split[0]).withLastName(split[1])
                .withPhoneHome(split[2]).withEmail(split[3]).withAddress(split[4]).withGroup(split[5])});
        line = reader.readLine();
      }
      return list.iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
      return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validContactsFromJson")
  public void testContactCreation(ContactData contact) {
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/stru.png");
    app.contact().create(contact.withPhoto(photo), true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

//  @Test
//  public void testContactCreation1() {
//    Contacts before = app.contact().all();
//    File photo = new File("src/test/resources/stru.png");
//    ContactData contact = new ContactData().withFirstName("FirstName1").withLastName("LastName1")
//            .withGroup("Group1").withPhoto(photo);
//    app.contact().create(contact, true);
//    assertThat(app.contact().count(), equalTo(before.size() + 1));
//    Contacts after = app.contact().all();
//    assertThat(after, equalTo(
//            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
//  }


//  @Test(dataProvider = "validGroupsFromJson")
//  public void testGroupCreation(GroupData group) {
//    app.goTo().groupPage();
//    Groups before = app.group().all();
//    app.group().create(group);
//    assertThat(app.group().count(), equalTo(before.size() + 1));
//    Groups after = app.group().all();
//    assertThat(after, equalTo(
//            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
//  }

  @Test(enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/stru.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }

  @Test(enabled = false)//для отключения теста
  public void testBadContactCreation() {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("FirstName1'").withLastName("LastName1").withGroup("Group1");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
}
