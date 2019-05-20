package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();                         //будет содержать список элементов до того, как создана новая группа. Список поменяли на множество
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    app.goTo().groupPage();
    Set<GroupData> after = app.group().all();                          // будет содержать список элементов после того, как создана новая группа
    Assert.assertEquals(after.size(), before.size() + 1);       //размер списка до создания новой группы должен быть на один меньше, чем после создания. Список поменяли на множетсво

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before, after);
   }
}
