package com.example.spring_hm_3.services;

import com.example.spring_hm_3.models.User;
import com.example.spring_hm_3.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
  private UsersRepository usersRepository;
  private NotificationService notificationService;

  @Autowired
  public DataProcessingService(UsersRepository userRepository, NotificationService notificationService) {
    this.usersRepository = userRepository;
    this.notificationService = notificationService;
  }

  /**
   * Попытка добавить пользователя в БД
   * @param user
   * @return
   */
  public boolean checkUser(User user) {
    if (!ifExists(user)) {
      usersRepository.add(user);
      notificationService.userAdded(user);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Возвращает список пользователей
   *
   * @return
   */
  public List<User> getUsersFromDB() {
    return usersRepository.selectAllFromDB();
  }

  /**
   * Проверяет на наличие в БД уже зарегистрированного пользователя
   *
   * @param user
   * @return
   */
  public boolean ifExists(User user) {
    return getUsersFromDB().contains(user);
  }

  /**
   * Фильтрует список пользователей по возрасту
   * @param users
   * @return
   */
  public List<User> sortUsersByAge(List<User> users) {
    return users.stream()
            .sorted(Comparator.comparing(User::getAge))
            .collect(Collectors.toList());
  }

  /**
   * Возвращает список пользователей старше age
   * @param users
   * @param age
   * @return
   */
  public List<User> filterUsersByAge(List<User> users, int age) {
    return users.stream()
            .filter(user -> user.getAge() > age)
            .collect(Collectors.toList());
  }

  /**
   * Считает средний возраст пользователей
   * @param users
   * @return
   */
  public double calculateAverageAge(List<User> users) {
    return users.stream()
            .mapToInt(User::getAge)
            .average()
            .orElse(0);
  }
}


