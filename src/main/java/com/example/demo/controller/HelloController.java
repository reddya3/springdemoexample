package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//  the property is taken from the application.properties file and you can refer to it
  @Value("${welcome.message}")
  private String welcomeMessage;

  @GetMapping("/hello")
  public String helloWorld() {
    return welcomeMessage;
  }
}
