package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class UserCreationTest extends TestBase {


  @Test
  public void testUserCreation() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    List<UserData> before = app.getUserHelper().getUserList();
    System.out.println("Before "+ before.size());
    for (int i = 0; i < before.size(); i++){
      System.out.println("Before " + i + before.get(i));
    }
    app.getNavigationHelper().gotoAddNewUserPage();
    app.getUserHelper().createUser(new UserData("Qwertyu", "Asdfghj", "Test", "Main strett, 25", "test@test.com", "Test 1"), true);
    app.getNavigationHelper().gotoHomePage();
    List<UserData> after = app.getUserHelper().getUserList();
    System.out.println(("After "+ after.size()));
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}
