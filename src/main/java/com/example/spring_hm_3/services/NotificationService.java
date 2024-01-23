package com.example.spring_hm_3.services;

import com.example.spring_hm_3.models.User;
import org.springframework.stereotype.Service;

/*
Сервис возвращает сообщение о том, что пользователь создан и
и выводит это сообщение в консоль
 */
@Service
public class NotificationService {

  /**
   * Уведомление о создании пользователя
   * @param user
   */
  public void notifyUser(User user){
    String message = "Создан пользователь: " + user;
    System.out.println(message);
  }

  /**
   * Уведомление об успешной/неуспешной регистрации
   * @param user
   * @param resultRegistration
   * @return
   */
  public String resultRegistration(User user, boolean resultRegistration){
    String notification = resultRegistration ?
            String.format("Зарегистрирован новый пользователь: %s", user) :
            String.format("Пользователь: %s - не зарегистрирован", user);
    System.out.println(notification);
    return notification;
  }

  /**
   * Уведомление об успешном/неуспешном добавлении в БД
   * @param user
   */
  public void userAdded(User user){
    System.out.println(user == null ?
            String.format("Пользователь с email: \"%s\" уже зарегистрирован", user.getEmail()) :
            String.format("Пользователь %s - добавлен в БД", user));
  }
}