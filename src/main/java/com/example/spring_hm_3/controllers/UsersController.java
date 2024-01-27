package com.example.spring_hm_3.controllers;

import com.example.spring_hm_3.models.User;
import com.example.spring_hm_3.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users") // Добавляет префикс ко всем запросам
public class UsersController {
  @Autowired
  private RegistrationService registrationService;
  @GetMapping
  public List<User> showUsers(){
    return registrationService.getUserList();
  }

  @GetMapping("/body")
  public String registration(){
    return "Отправляю на шаблон с регистрацией нового пользователя";
  }

  @PostMapping("/body")
  public String registration(@RequestBody User user){
    String notification = registrationService.processRegistration(user.getName(),
                    user.getAge(),user.getEmail());
    return notification;
  }
//  @PostMapping("/body")
//  public String registration(@RequestBody Map<String, Object> requestBody){
//    String name = String.valueOf(requestBody.get("name"));
//    Integer age = (Integer)requestBody.get("age");
//    String email = String.valueOf(requestBody.get("email"));
//    String notification = registrationService.processRegistration(name, age, email);
//    return notification;
//  }

}
