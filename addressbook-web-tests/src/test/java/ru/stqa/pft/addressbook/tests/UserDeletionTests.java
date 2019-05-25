package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Set;

public class UserDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if(app.user().all().size() == 0){
      app.user().create(new UserData().withFirstname("Qwertyu").withLastname("Asdfghj").withNickname("Test").withAddress("Main strett, 25").withEmail("test@test.com").withGroup("Test 1"), true);
    }
  }

  @Test
  public void testUserDeletion(){
    Set<UserData> before = app.user().all();
    UserData deletedUser = before.iterator().next();
    app.user().delete(deletedUser);
    app.goTo().homePage();
    Set<UserData> after = app.user().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedUser);
    Assert.assertEquals(before, after);
  }


}
