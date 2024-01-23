package com.example.spring_hm_3.models;

/*
Моделька пользователя имя, почта, возраст.
Геттеры и Сеттеры. Всё
 */
public class User {
  private String name, email;
  private int id, age;

//  public User(String name, String email, int age) {
//    this.name = name;
//    this.email = email;
//    this.age = age;
//  }

  //region Get Set
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
  //endregion

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return email.equals(user.email);
  }

  @Override
  public String toString() {
    return "User{" +
            "name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", age=" + age +
            '}';
  }
}
