package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();//будет содержать список элементов до того, как создана новая группа
    for (int i = 0; i < before.size(); i++){
      System.out.println("Before " + i + before.get(i));
    }
    app.getGroupHelper().createGroup(new GroupData("Test 1", null, null));
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList(); // будет содержать список элементов после того, как создана новая группа
    Assert.assertEquals(after.size(), before.size() + 1);//размер списка до создания новой группы должен быть на один меньше, чем после создания
  }
}
