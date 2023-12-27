package com.example.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.firstproject.form.CalculatorForm;
import com.example.firstproject.form.MemberForm;
import com.example.firstproject.service.CalculatorService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/calculators")
public class CalculatorController {
    
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String index(Model model,CalculatorForm calculatorForm) {
        return "calculators/input";
    }
    
    @PostMapping("/post")
    public String calculator( @Validated CalculatorForm calculatorForm,//request
                BindingResult result ,//エラーメッセージを格納
				RedirectAttributes redirectAttributes, //flashスコープを扱うため。
                Model model) {
        System.out.println("5555");
         //エラーがあった場合は、遷移させない。
         if(result.hasErrors()){
            System.out.println("errrorrrrrr");
            return index(model,calculatorForm);
        }
        int num1 = calculatorForm.getNum1();
        int num2 = calculatorForm.getNum2();
        int calResult = calculatorService.addNumber(num1, num2);
        System.out.println(calResult);
        return "redirect:/calculators/";
    }
    
}
