package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserModificationTests extends TestBase {

  @Test
  public void testUserModification(){
    app.getNavigationHelper().gotoHomePage();
    int before = app.getUserHelper().getUserCount();
    if(! app.getUserHelper().isThereAUser()){
      app.getUserHelper().createUser(new UserData("Qwertyu", "Asdfghj", "Test", "Main strett, 25", "test@test.com", "Test 1"), true);
    }
    app.getUserHelper().pressEditIcon();
    app.getUserHelper().fillUserData(new UserData("UpdateName", "updateLastName", "UpdateNick", "New address, 25", "newtest@test.com", null), false);
    app.getUserHelper().submitUserModification();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getUserHelper().getUserCount();
    Assert.assertEquals(after, before);
  }
}
