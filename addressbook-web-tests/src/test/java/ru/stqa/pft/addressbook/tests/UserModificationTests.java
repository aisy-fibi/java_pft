package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserModificationTests extends TestBase {

  @Test
  public void testUserModification(){
    app.getNavigationHelper().gotoHomePage();
    app.getUserHelper().initUserModification();
    app.getUserHelper().fillUserData(new UserData("UpdateName", "updateLastName", "UpdateNick", "New address, 25", "newtest@test.com"));
    app.getUserHelper().submitUserModification();
  }
}
