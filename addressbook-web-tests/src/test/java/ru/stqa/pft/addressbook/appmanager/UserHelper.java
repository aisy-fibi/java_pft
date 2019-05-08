package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.UserData;

public class UserHelper extends HelperBase{


  public UserHelper(WebDriver wd) {
    super(wd);
  }

  public void submitUserCreation() {
    click(By.xpath("//*[@id=\"content\"]/form/input[21]"));
  }

  public void pressEditIcon(){
    click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
  }

  public void initUserCreation(){
    click(By.linkText("add new"));
  }

  public void fillUserData(UserData userData, boolean creation) {
    type(By.name("firstname"), userData.getFirstname());
    type(By.name("lastname"), userData.getLastname());
    type(By.name("nickname"), userData.getNickname());
    type(By.name("address"), userData.getAddress());
    type(By.name("email"), userData.getEmail());

    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroup());
    } else {
      Assert.assertFalse(isElementPresented(By.name("new_group")));
    }
  }

  public void submitUserModification() {
    click(By.xpath("//*[@id=\"content\"]/form[1]/input[22]"));
  }

  public void deleteUserFromEditPage() {
    click(By.xpath("//*[@id=\"content\"]/form[2]/input[2]"));
  }

  public void createUser(UserData user, boolean b) {
    initUserCreation();
    fillUserData(user, b);
    submitUserCreation();
  }

  public boolean isThereAUser() {
    return isElementPresented(By.name("selected[]"));
  }

  public int getUserCount() {
    return wd.findElements(By.name("entry")).size();
  }
}
