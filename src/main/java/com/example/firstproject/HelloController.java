package com.example.firstproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
    
    @GetMapping("/")
    public String index()
    {
        return "hello";
    }
 
    @GetMapping("/sample")
    public String sample()
    {
        return "hello-sample";
    }
}
