package com.example.firstproject.form;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class MemberForm {
    //名前
    @NotBlank(message = "名前は必須です。")
    private String name;
    //年齢
    private Integer age;
    //性別
    private String gender;
    //所持金
    private Integer money;
    //コメント
    private String comment;
    //誕生日
    private LocalDate birthDay;
    //趣味リスト
     @NotEmpty(message = "趣味は必須です。")
    private List<Integer> hobbyList;

 
}
