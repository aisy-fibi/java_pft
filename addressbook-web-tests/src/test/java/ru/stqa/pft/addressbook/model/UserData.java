package ru.stqa.pft.addressbook.model;

public class UserData {
  private int id;
  private final String firstname;
  private final String lastname;
  private final String nickname;
  private final String address;
  private final String email;
  private final String group;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserData userData = (UserData) o;

    if (firstname != null ? !firstname.equals(userData.firstname) : userData.firstname != null) return false;
    return lastname != null ? lastname.equals(userData.lastname) : userData.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  public UserData(String firstname, String lastname, String nickname, String address, String email, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.address = address;
    this.email = email;
    this.group = group;
  }

  public UserData(int id, String firstname, String lastname, String nickname, String address, String email, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.address = address;
    this.email = email;
    this.group = group;
  }

  public UserData(int id, String firstname, String lastname){
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = null;
    this.address = null;
    this.email = null;
    this.group = null;
  }


  public void setId(int id) {
    this.id = id;
  }


  @Override
  public String toString() {
    return "UserData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public int getId() {return id; }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup(){
    return group;
  }

}
