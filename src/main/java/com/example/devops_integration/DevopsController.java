package com.example.devops_integration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevopsController {

    @RequestMapping("/")
    public String sayHello(){
        return "Hello";
    }
}
