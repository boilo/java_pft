package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[] {new ContactData()
              .withFirstname(split[0]).withLastname(split[1]).withAddress(split[2]).withHomephone(split[3])
              .withMobilephone(split[4]).withWorkphone(split[5]).withEmailone(split[6]).withEmailtwo(split[7])
              .withEmailthree(split[8])});
      line = reader.readLine();
    }
    return list.iterator();
  }

  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/zoid.png");
    /*ContactData contact = new ContactData().withFirstname("Ivan").withLastname("Ivanov").withPhoto(photo)
            .withAddress("Moscow, Esenina 1/21").withHomephone("+7 (111)")
            .withMobilephone("22-22").withWorkphone("33 33 33")
            .withEmailone("ivan.ivanov@gmail.com").withEmailtwo("ivan1@mail.ru")
            .withEmailthree("ivan_i@yandex.ru").withGroup("[none]");*/
    app.contact().create(contact, true);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
