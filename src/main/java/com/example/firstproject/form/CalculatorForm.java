package com.example.firstproject.form;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CalculatorForm {
    
    //一つ目の数字
    @NotNull(message = "入力は必須です。")//@notBlunkは文字列判断
    private Integer num1;
    //二つ目の数字
    @NotNull(message = "入力は必須です。")
    private Integer num2;
}
