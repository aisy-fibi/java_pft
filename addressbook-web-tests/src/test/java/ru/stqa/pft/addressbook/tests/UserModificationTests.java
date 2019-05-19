package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class UserModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if( app.user().list().size() == 0){
      app.user().create(new UserData().withFirstname("Qwertyu").withLastname("Asdfghj").withNickname("Test").withAddress("Main strett, 25").withEmail("test@test.com").withGroup("Test 1"), true);
    }
   }

  @Test
  public void testUserModification(){
    List<UserData> before = app.user().list();
    int index = before.size() - 2;
    UserData user = new UserData().withId(before.get(index).getId()).withFirstname("UpdateThirdName").withLastname("updateThirdLastName").withNickname("UpdateNick").withAddress("New address, 25").withEmail("newtest@test.com").withGroup(null);
    app.user().modify(index, user);
    app.goTo().homePage();
    List<UserData> after = app.user().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(user);
    Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }


}
