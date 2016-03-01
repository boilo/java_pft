package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by User on 01.03.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion(){
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();

  }
}
