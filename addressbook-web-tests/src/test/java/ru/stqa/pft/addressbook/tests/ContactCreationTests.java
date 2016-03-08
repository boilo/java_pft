package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() {
    app.getContactHelper().createContact(new ContactData("Ivan", "Ivanov", "Minsk", "01", "02", "03", "04", "test1"), true);
    app.getNavigationHelper().gotoHomePage();
  }

}
