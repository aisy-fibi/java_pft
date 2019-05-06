package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserDeletionTests extends TestBase{

  @Test
  public void testUserDeletion(){
    app.getNavigationHelper().gotoHomePage();
    if(! app.getUserHelper().isThereAUser()){
      app.getUserHelper().createUser(new UserData("Qwertyu", "Asdfghj", "Test", "Main strett, 25", "test@test.com", "Test 1"), true);
    }
    app.getUserHelper().pressEditIcon();
    app.getUserHelper().deleteUserFromEditPage();
  }
}
