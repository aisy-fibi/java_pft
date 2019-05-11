package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.HashSet;
import java.util.List;

public class UserModificationTests extends TestBase {

  @Test
  public void testUserModification(){
    app.getNavigationHelper().gotoHomePage();
    if(! app.getUserHelper().isThereAUser()){
      app.getUserHelper().createUser(new UserData("Qwertyu", "Asdfghj", "Test", "Main strett, 25", "test@test.com", "Test 1"), true);
    }
    List<UserData> before = app.getUserHelper().getUserList();
    //int before = app.getUserHelper().getUserCount();
    app.getUserHelper().pressEditIcon(before.size() - 2);
    UserData user = new UserData(before.get(before.size() - 2).getId(), "UpdateThirdName", "updateThirdLastName", "UpdateNick", "New address, 25", "newtest@test.com", null);
    app.getUserHelper().fillUserData(user, false);
    app.getUserHelper().submitUserModification();
    app.getNavigationHelper().gotoHomePage();
    List<UserData> after = app.getUserHelper().getUserList();
    //int after = app.getUserHelper().getUserCount();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 2);
    before.add(user);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }
}
