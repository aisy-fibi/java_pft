package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class UserDeletionTests extends TestBase{

  @Test
  public void testUserDeletion(){
    app.getNavigationHelper().gotoHomePage();
    //int before = app.getUserHelper().getUserCount();
    if(! app.getUserHelper().isThereAUser()){
      app.getUserHelper().createUser(new UserData("Qwertyu", "Asdfghj", "Test", "Main strett, 25", "test@test.com", "Test 1"), true);
    }
    List<UserData> before = app.getUserHelper().getUserList();
    app.getUserHelper().selectUser(before.size() - 1);
    app.getUserHelper().deleteUserFromUserTable();
    app.getUserHelper().closePopUp();
    //app.getUserHelper().pressEditIcon(); это удаление пользователя со страницы эдита
    //app.getUserHelper().deleteUserFromEditPage();
    app.getNavigationHelper().gotoHomePage();
    //int after = app.getUserHelper().getUserCount();
    List<UserData> after = app.getUserHelper().getUserList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
  }
}
