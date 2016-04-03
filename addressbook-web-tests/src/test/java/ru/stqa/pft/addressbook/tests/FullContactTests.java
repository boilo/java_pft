package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by User on 02.04.2016.
 */
public class FullContactTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      File photo = new File("src/test/resources/zoid.png");
      app.contact().create(new ContactData()
              .withFirstname("Ivan").withLastname("Ivanov").withAddress("Moscow, Esenina 1/21").withPhoto(photo)
              .withHomephone("+7 (111)").withMobilephone("22-22").withWorkphone("33 33 33")
              .withEmailone("ivan.ivanov@gmail.com").withEmailtwo("ivan1@mail.ru")
              .withEmailthree("ivan_i@yandex.ru").withGroup("[none]"), true);
    }
  }

  @Test
  public void testFullContact() {
    app.goTo().gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    String contactInfoFromAboutForm = app.contact().InfoFromAboutForm(contact);
    assertThat(cleaned(contactInfoFromAboutForm), equalTo(mergeAll(contactInfoFromEditForm)));

  }

  private String mergeAll(ContactData contact) {
    return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getAddress(), contact.getHomephone(),
            contact.getMobilephone(), contact.getWorkphone(), contact.getEmailone(), contact.getEmailtwo(),
            contact.getEmailthree())
            .stream().filter((s)->! s.equals(""))
            .map(FullContactTests::cleaned2)
            .collect(Collectors.joining(""));
  }

  private static String cleaned(String contact) {
    return contact.replaceAll("\\s", "").replaceAll("\\(www\\..*?\\..*?\\)", "")
            .replaceAll("[-()]", "").replaceAll("H:|M:|W:", "");
  }

  private static String cleaned2(String contact) {
    return contact.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
