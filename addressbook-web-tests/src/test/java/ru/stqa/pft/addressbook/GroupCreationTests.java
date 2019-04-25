package ru.stqa.pft.addressbook;


import org.testng.annotations.*;
import org.openqa.selenium.*;


public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Test 1", "Test 2", "Test 3"));
    submitGroupCreation();
    returnToGroupPage();
    wd.findElement(By.linkText("Logout")).click();
  }

}
