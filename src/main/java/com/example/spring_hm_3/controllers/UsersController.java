package com.example.spring_hm_3.controllers;

import com.example.spring_hm_3.models.User;
import com.example.spring_hm_3.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
