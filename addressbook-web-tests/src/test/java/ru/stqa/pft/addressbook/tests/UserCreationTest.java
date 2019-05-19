package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class UserCreationTest extends TestBase {


  @Test
  public void testUserCreation() throws Exception {
    app.goTo().homePage();
    List<UserData> before = app.user().list();
    app.goTo().gotoAddNewUserPage();
    UserData user = new UserData().withFirstname("Qwertyu").withLastname("Asdfghj").withNickname("Test").withAddress("Main strett, 25").withEmail("test@test.com").withGroup("Test 1");
    app.user().create(user, true);
    app.goTo().homePage();
    List<UserData> after = app.user().list();
    Assert.assertEquals(after.size(), before.size() + 1);


    before.add(user);
    Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
