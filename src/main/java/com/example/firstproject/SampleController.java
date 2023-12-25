package com.example.firstproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class SampleController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/indexx")
    public String index2(){
        return "info-form";
    }
    @GetMapping("/sample")
    public String sample(){
        return "sample";
    }
    @GetMapping("/helloSample")
    public String helloSample(){
        return "hello-sample";
    }
    @GetMapping("/redirect")
    public String redirectSample(){
        return "redirect";
    }

    @GetMapping("/redirect2")
    public String redirectMethod() {
       
        return "redirect:/hello/sample";
    }
    
}
