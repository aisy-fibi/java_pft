package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Set;

public class UserModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if( app.user().all().size() == 0){
      app.user().create(new UserData().withFirstname("Qwertyu").withLastname("Asdfghj").withNickname("Test").withAddress("Main strett, 25").withEmail("test@test.com").withGroup("Test 1"), true);
    }
   }

  @Test
  public void testUserModification(){
    Set<UserData> before = app.user().all();
    UserData modifiedUser = before.iterator().next();
    UserData user = new UserData().withId(modifiedUser.getId()).withFirstname("UpdateThirdName").withLastname("updateThirdLastName").withNickname("UpdateNick").withAddress("New address, 25").withEmail("newtest@test.com").withGroup(null);
    app.user().modify(user);
    app.goTo().homePage();
    Set<UserData> after = app.user().all();
    Assert.assertEquals(before.size(), after.size());

    before.remove(modifiedUser);
    before.add(user);
    Assert.assertEquals(before, after);
    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }


}
