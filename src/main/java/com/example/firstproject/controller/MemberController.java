package com.example.firstproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.Member;
import com.example.firstproject.form.ReceiveForm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/members")
public class MemberController {
    
    @GetMapping("/")
    public String index() {
        return "members/register-member";
    }

    @PostMapping("/register")
    public ModelAndView registerMember(@ModelAttribute Member member,
				ModelAndView mav) {
        mav.addObject("member",member);
        mav.setViewName("members/output-member.html");
        return mav;
    }
    // @PostMapping("/register")
    // public String registerMember(){
    //     return "members/register-member";
    // }
    
    
    
}
