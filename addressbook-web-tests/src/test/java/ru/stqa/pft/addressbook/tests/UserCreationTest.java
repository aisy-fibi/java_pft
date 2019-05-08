package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserCreationTest extends TestBase {


  @Test
  public void testUserCreation() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getUserHelper().getUserCount();
    System.out.println("User count before: " + before);
    app.getNavigationHelper().gotoAddNewUserPage();
    app.getUserHelper().createUser(new UserData("Qwertyu", "Asdfghj", "Test", "Main strett, 25", "test@test.com", "Test 1"), true);
    app.getNavigationHelper().gotoHomePage();
    int after = app.getUserHelper().getUserCount();
    System.out.println("User count after: " + after);
    Assert.assertEquals(after, before + 1);
  }

}
