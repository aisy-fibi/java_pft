package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Set;

public class UserCreationTest extends TestBase {


  @Test
  public void testUserCreation() throws Exception {
    app.goTo().homePage();
    Set<UserData> before = app.user().all();
    app.goTo().gotoAddNewUserPage();
    UserData user = new UserData().withFirstname("Qwertyu").withLastname("Asdfghj").withNickname("Test").withAddress("Main strett, 25").withEmail("test@test.com").withGroup("Test 1");
    app.user().create(user, true);
    app.goTo().homePage();
    Set<UserData> after = app.user().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    user.withId(after.stream().mapToInt((u) -> u.getId()).max().getAsInt());
    before.add(user);
    Assert.assertEquals(before, after); // множетсва не надо сортировать, их можно сразу сравнивать
  }
}
