package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserHelper extends HelperBase {


  public UserHelper(WebDriver wd) {
    super(wd);
  }

  public void submitUserCreation() {
    click(By.xpath("//*[@id=\"content\"]/form/input[21]"));
  }

  public void pressEditIcon(int index) {
    wd.findElements(By.xpath("//a[contains(@href,'edit.php?id=')]")).get(index).click();

            //("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));////*[@id="maintable"]/tbody/tr[3]/td[8]/a/img
  }

  public void initUserCreation() {
    click(By.linkText("add new"));
  }

  public void fillUserData(UserData userData, boolean creation) {
    type(By.name("firstname"), userData.getFirstname());
    type(By.name("lastname"), userData.getLastname());
    type(By.name("nickname"), userData.getNickname());
    type(By.name("address"), userData.getAddress());
    type(By.name("email"), userData.getEmail());

    if (creation) {
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

  public void create(UserData user, boolean b) { // это функция создания пользователя
    initUserCreation();
    fillUserData(user, b);
    submitUserCreation();
  }

  public void modify(UserData user) {
    pressEditIconById(user.getId());
    fillUserData(user, false);
    submitUserModification();
   }

  private void pressEditIconById(int id) {
    wd.findElement(By.xpath("//a[contains(@href,'edit.php?id="+ id +"')]")).click();
  }

  private void initUserModification() {

    click(By.name("edit"));
  }

    public void delete(UserData user) {
    selectUserById(user.getId());
    deleteUserFromUserTable();
    closePopUp();
  }

  public boolean isThereAUser() {
    return isElementPresented(By.name("selected[]"));
  }

  public int getUserCount() {
    return wd.findElements(By.name("entry")).size();
  }

  public void selectUserById(int id)
  {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }


  public void deleteUserFromUserTable() {
    click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
  }

  public void closePopUp() {
    wd.switchTo().alert().accept();
  }

  public Set<UserData> all() {
    Set<UserData> users = new HashSet<UserData>();  // создается множество элементов типа ЮзерДата
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){            // для каждого элемента вытаскиваем имя и идентификатор
      List<WebElement> entryElements = element.findElements(By.tagName("td"));
      String firstName = entryElements.get(2).getText();
      String lastName =  entryElements.get(1).getText();
      //String LastName = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      users.add(new UserData().withId(id).withFirstname(firstName).withLastname(lastName)); // создаем новый обьект с такими атрибутами и помещаем его в множество
    }
    return users;
  }

}
