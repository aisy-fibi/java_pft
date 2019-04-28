package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserCreationTest extends TestBase {


  @Test
  public void testUserCreation() throws Exception {

    app.gotoAddNewUserPage();
    app.fillUserData(new UserData("Qwertyu", "Asdfghj", "Test", "Main strett, 25", "test@test.com"));
    app.submitUserCreation();
  }

}
