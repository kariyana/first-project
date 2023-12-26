package com.example.firstproject.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.Member;
import com.example.firstproject.form.MemberForm;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;






@Controller
@RequestMapping("/members")
public class MemberController {
    
    @GetMapping("/")
    public String index(Model model,MemberForm memberForm) {

        Map<Integer,String> hobbyMap = new LinkedHashMap<>();
        hobbyMap.put(1,"スポーツ");
        hobbyMap.put(2,"読書");
        hobbyMap.put(3,"勉強");
        hobbyMap.put(4,"料理");

        model.addAttribute("hobbyMap", hobbyMap);
        return "members/register-member";
    }

    @PostMapping("/register")
    public String registerMember(
                @Validated MemberForm memberForm,//request
                BindingResult result ,//エラーメッセージを格納
				RedirectAttributes redirectAttributes, //flashスコープを扱うため。
                Model model
    ) {
        //エラーがあった場合は、遷移させない。
        if(result.hasErrors()){
            return index(model,memberForm);
        }
        //メンバーのインスタンス化            
        Member member = new Member();
        //formの内容でプロパティが一致するものをコピーする。
        BeanUtils.copyProperties(memberForm, member);

        //form と　memberでhobbyListの型が違うから、別途オブジェクトを追加する。
        List<String> hobbyList = new ArrayList<>();
        for(Integer hobbyCode : memberForm.getHobbyList()){
            switch (hobbyCode) {
                case 1:
                    hobbyList.add("スポーツ");
                    break;
                case 2:
                    hobbyList.add("読書");
                    break;
                case 3:
                    hobbyList.add("勉強");
                    break;
                case 4:
                    hobbyList.add("料理");
                    break;
            }
        }
        //作成したリストをセット。
        member.setHobbyList(hobbyList);
        //フラッシュスコープ
        redirectAttributes.addFlashAttribute("member",member);
        System.out.println();
        return "redirect:/members/output";
    
    }

    @GetMapping("/output")
    public String output() {
        return "members/output-member";
    }
    
    // @PostMapping("/register")
    // public String registerMember(){
    //     return "members/register-member";
    // }
    
    
    
}
