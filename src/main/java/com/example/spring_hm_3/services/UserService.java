package com.example.spring_hm_3.services;

import com.example.spring_hm_3.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
Сервис создаёт объект пользователя и заполняет его поля
полученными параметрами
 */
@Service
public class UserService {

  private NotificationService notificationService;

  @Autowired
  public UserService(NotificationService notificationService) {
    this.notificationService = notificationService;
  }
  public User createUser(String name, int age, String email){
    User user = new User();
    user.setAge(age);
    user.setEmail(email);
    user.setName(name);
    notificationService.notifyUser(user); // собщаем о создании пользователя
    return user;
  }
}