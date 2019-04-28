package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class UserCreationTest extends TestBase {


  @Test
  public void testUserCreation() throws Exception {

    gotoAddNewUserPage();
    fillUserData(new UserData("Qwertyu", "Asdfghj", "Test", "Main strett, 25", "test@test.com"));
    submitUserCreation();
  }

}
