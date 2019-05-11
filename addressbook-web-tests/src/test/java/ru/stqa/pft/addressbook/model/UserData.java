package ru.stqa.pft.addressbook.model;

public class UserData {
  private final String id;
  private final String firstname;
  private final String lastname;
  private final String nickname;
  private final String address;
  private final String email;
  private final String group;

  public UserData( String firstname, String lastname, String nickname, String address, String email, String group) {
    this.id = null;
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.address = address;
    this.email = email;
    this.group = group;
  }

  public UserData(String id, String firstname, String lastname, String nickname, String address, String email, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.address = address;
    this.email = email;
    this.group = group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserData userData = (UserData) o;

    if (id != null ? !id.equals(userData.id) : userData.id != null) return false;
    if (firstname != null ? !firstname.equals(userData.firstname) : userData.firstname != null) return false;
    return lastname != null ? lastname.equals(userData.lastname) : userData.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "UserData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public String getId() {return id; }

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
