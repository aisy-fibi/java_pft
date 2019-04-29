package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.UserData;

public class UserHelper extends HelperBase{


  public UserHelper(WebDriver wd) {
    super(wd);
  }

  public void submitUserCreation() {
    click(By.xpath("//*[@id=\"content\"]/form/input[21]"));
  }

  public void fillUserData(UserData userData) {
    type(By.name("firstname"),userData.getFirstname());
    type(By.name("lastname"),userData.getLastname());
    type(By.name("nickname"),userData.getNickname());
    type(By.name("address"),userData.getAddress());
    type(By.name("email"),userData.getEmail());
   }
}
