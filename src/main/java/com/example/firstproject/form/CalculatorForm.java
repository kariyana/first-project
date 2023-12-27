package com.example.firstproject.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CalculatorForm {
    
    //1つ目の数字
    @NotNull(message = "左のテキストボックスに数値を入力してください。")//@notBlunkは文字列判断
    @Max(10000)
    private Integer num1;
    //2つ目の数字
    @NotNull(message = "右のテキストボックスに数値を入力してください。")//@notBlunkは文字列判断
    @Max(10000)
    private Integer num2;

}
