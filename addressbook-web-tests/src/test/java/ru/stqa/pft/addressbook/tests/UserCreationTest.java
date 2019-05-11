package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import javax.jws.soap.SOAPBinding;
import java.util.HashSet;
import java.util.List;

public class UserCreationTest extends TestBase {


  @Test
  public void testUserCreation() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    List<UserData> before = app.getUserHelper().getUserList();
    app.getNavigationHelper().gotoAddNewUserPage();
    UserData user = new UserData("Qwertyu", "Asdfghj", "Test", "Main strett, 25", "test@test.com", "Test 1");
    app.getUserHelper().createUser(user, true);
    app.getNavigationHelper().gotoHomePage();
    List<UserData> after = app.getUserHelper().getUserList();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max = 0;
    for (UserData u : after){
      if (u.getId() > max){
        max = u.getId();
      }
    }
    user.setId(max);
    before.add(user);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
