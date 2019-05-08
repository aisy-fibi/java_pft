package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserDeletionTests extends TestBase{

  @Test
  public void testUserDeletion(){
    app.getNavigationHelper().gotoHomePage();
    int before = app.getUserHelper().getUserCount();
    if(! app.getUserHelper().isThereAUser()){
      app.getUserHelper().createUser(new UserData("Qwertyu", "Asdfghj", "Test", "Main strett, 25", "test@test.com", "Test 1"), true);
    }
    app.getUserHelper().selectUser(before - 1);
    app.getUserHelper().deleteUserFromUserTable();
    app.getUserHelper().closePopUp();
    //app.getUserHelper().pressEditIcon();
    //app.getUserHelper().deleteUserFromEditPage();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getUserHelper().getUserCount();
    Assert.assertEquals(after, before - 1);
  }
}
