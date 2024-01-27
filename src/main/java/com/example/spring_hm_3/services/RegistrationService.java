package com.example.spring_hm_3.services;

import com.example.spring_hm_3.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
  private UserService userService;
  private DataProcessingService dataProcessingService;
  private NotificationService notificationService;

  /**
   * Конструктор с нужными нам объектами
   * @param userService
   * @param dataProcessingService
   * @param notificationService
   */
  public RegistrationService(UserService userService, DataProcessingService dataProcessingService, NotificationService notificationService) {
    this.userService = userService;
    this.dataProcessingService = dataProcessingService;
    this.notificationService = notificationService;
  }

  /**
   * Регистрируем нового пользователя
   * @param name
   * @param age
   * @param email
   */
  public String processRegistration(String name, int age, String email){
    User user = userService.createUser(name, age, email); // создаём объект пользователя

    // пробуем добавить, выводим в консоль результат
    String notification = notificationService.resultRegistration(user, dataProcessingService.checkUser(user));
    return notification;
  }

  /**
   * Получаем список пользователей
   * @return
   */
  public List<User> getUserList() {
    return dataProcessingService.getUsersFromDB();
  }

}
