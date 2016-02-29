package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactData(new ContactData("Ivan", "Ivanov", "Minsk", "01", "02", "03", "04"));
    app.getContactHelper().submitContactCreation();
  }

}
