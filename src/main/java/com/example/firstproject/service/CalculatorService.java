package com.example.firstproject.service;

import org.springframework.stereotype.Component;

@Component
public class CalculatorService {
    
    public int addNumber(Integer num1,Integer num2)
    {
        return num1 + num2;
    }
    public int subNumber(Integer num1,Integer num2)
    {
        return num1 - num2;
    }
    public int multiNumber(Integer num1,Integer num2)
    {
        return num1 * num2;
    }
    public int divNumber(Integer num1,Integer num2)
    {
        return num1 / num2;
    }
}
