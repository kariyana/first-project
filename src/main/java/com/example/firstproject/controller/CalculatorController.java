package com.example.firstproject.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.firstproject.form.CalculatorForm;

import com.example.firstproject.service.CalculatorService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
@RequestMapping("/calculators")
public class CalculatorController {
    
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String index(Model model,CalculatorForm calculatorForm) {
        Map<Integer,String> symbolList = new LinkedHashMap<>();
        symbolList.put(1,"+");
        symbolList.put(2,"-");
        symbolList.put(3,"×");
        symbolList.put(4,"÷");
 
        model.addAttribute("symbolList", symbolList);
        return "calculators/input";
    }
    
    @PostMapping("/post")
    public String calculator( @Validated CalculatorForm calculatorForm,//request
                BindingResult result ,//エラーメッセージを格納
				RedirectAttributes redirectAttributes, //flashスコープを扱うため。
                Model model) {
   
         //エラーがあった場合は、遷移させない。
         if(result.hasErrors()){
            System.out.println("errrorrrrrr");
            return index(model,calculatorForm);
        }
        int num1 = calculatorForm.getNum1();
        int num2 = calculatorForm.getNum2();
    
     
        Integer symbol = calculatorForm.getSymbol();
        Integer calResult = 0 ;
        switch (symbol) {
            case 1:
                calResult = calculatorService.addNumber(num1, num2);
                break;
            case 2:
                calResult = calculatorService.subNumber(num1, num2);
                break;
            case 3:
                calResult = calculatorService.multiNumber(num1, num2);
                break;
            case 4:
                calResult = calculatorService.divNumber(num1, num2);
                break;
        }
        redirectAttributes.addFlashAttribute("calResult", calResult);
        redirectAttributes.addFlashAttribute("calculatorForm", calculatorForm);
        // model.addAttribute("calReslut", calResult);
        return "redirect:/calculators/";
    }

    @GetMapping("/output")
    public String output() {
        System.out.println("ページネーション");
        return "calculators/reslut";
    }
    
    
}
