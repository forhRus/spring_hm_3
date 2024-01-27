package com.example.spring_hm_3.controllers;

import com.example.spring_hm_3.models.User;
import com.example.spring_hm_3.services.DataProcessingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
  DataProcessingService dataProcessingService;

  public TasksController(DataProcessingService dataProcessingService) {
    this.dataProcessingService = dataProcessingService;
  }

  /**
   * Сортирует пользователей по возрасту
   * @return
   */
  @GetMapping("/sort")
  public List<User> sortByAge() {
    return dataProcessingService.sortUsersByAge(dataProcessingService.getUsersFromDB());
  }

  /**
   * Фильтрует пользователей по возрасту(старше age)
   * @param age
   * @return
   */
  @GetMapping("/filter/{age}")
  public List<User> filterByAge(@PathVariable("age") int age) {
    return dataProcessingService.filterUsersByAge(dataProcessingService.getUsersFromDB(), age);
  }

  /**
   * Средний возраст пользователей
   * @return
   */
  @GetMapping("/calc")
  public double calculateAverageAge() {
    return dataProcessingService.calculateAverageAge(dataProcessingService.getUsersFromDB());
  }
}
