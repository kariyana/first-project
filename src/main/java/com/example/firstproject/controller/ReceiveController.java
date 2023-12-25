package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/receive")
public class ReceiveController {
    
    @GetMapping("/")
    public String index()
    {
        return "info-form";
    }
 
    @PostMapping("/receive-info")
    public String receiveInfo(String name ,String age)
    {
        System.out.println(name);
        System.out.println(age);
        return "finished";
    }
}