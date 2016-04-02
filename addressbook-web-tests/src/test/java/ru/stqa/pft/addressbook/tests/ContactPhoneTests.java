package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by User on 30.03.2016.
 */
public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("Ivan").withLastname("Ivanov").withAddress("Moscow, Esenina 1/21")
              .withHomephone("+7 (111)").withMobilephone("22-22").withWorkphone("33 33 33")
              .withEmailone("ivan.ivanov@gmail.com").withEmailtwo("ivan1@mail.ru")
              .withEmailthree("ivan_i@yandex.ru").withGroup("[none]"), true);
    }
  }

  @Test
  public void testContactPhones() {
    app.goTo().gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    assertThat(contact.getHomephone(), equalTo(cleaned(contactInfoFromEditForm.getHomephone())));
    assertThat(contact.getMobilephone(), equalTo(cleaned(contactInfoFromEditForm.getMobilephone())));
    assertThat(contact.getWorkphone(), equalTo(cleaned(contactInfoFromEditForm.getWorkphone())));
    assertThat(contact.getEmailone(), equalTo(contactInfoFromEditForm.getEmailone()));
    assertThat(contact.getEmailtwo(), equalTo(contactInfoFromEditForm.getEmailtwo()));
    assertThat(contact.getEmailthree(), equalTo(contactInfoFromEditForm.getEmailthree()));

  }

  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
