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

  public void pressEditIcon(){
    click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
  }

  public void fillUserData(UserData userData) {
    type(By.name("firstname"),userData.getFirstname());
    type(By.name("lastname"),userData.getLastname());
    type(By.name("nickname"),userData.getNickname());
    type(By.name("address"),userData.getAddress());
    type(By.name("email"),userData.getEmail());
   }

  public void submitUserModification() {
    click(By.xpath("//*[@id=\"content\"]/form[1]/input[22]"));
  }

  public void deleteUserFromEditPage() {
    click(By.xpath("//*[@id=\"content\"]/form[2]/input[2]"));
  }
}
