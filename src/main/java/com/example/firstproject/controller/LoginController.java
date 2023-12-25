package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.firstproject.form.ReceiveForm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/login")
public class LoginController {
   //ログイン画面
    @GetMapping("/")
    public String index() {
        return "login";
    }

    //ログイン
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute ReceiveForm form,
				ModelAndView mav) {
        String email = form.getEmail();
        String pass = form.getPass();

		mav.addObject("email",email);
		mav.addObject("pass",pass);
		
        if(email.equals("abc@gmail.com") && pass.equals("abc")){
            mav.setViewName("login-success.html");
            return mav;               
        }else{
            mav.setViewName("failure.html");
            return mav;
        }
    }
    
    
}
