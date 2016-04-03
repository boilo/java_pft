package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/zoid.png");
    ContactData contact = new ContactData().withFirstname("Ivan").withLastname("Ivanov").withPhoto(photo)
            .withAddress("Moscow, Esenina 1/21").withHomephone("+7 (111)")
            .withMobilephone("22-22").withWorkphone("33 33 33")
            .withEmailone("ivan.ivanov@gmail.com").withEmailtwo("ivan1@mail.ru")
            .withEmailthree("ivan_i@yandex.ru").withGroup("[none]");
    app.contact().create(contact, true);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
