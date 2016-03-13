package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by User on 01.03.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModefication (){
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Ivan", "Ivanov", "Minsk", "01", "02", "03", "04", "test1"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().fillContactData(new ContactData("Vladimir", "Sidorov", "Moscow", "01", "02", "03", "04", null), false);
    app.getContactHelper().submitContactModification();



  }
}
