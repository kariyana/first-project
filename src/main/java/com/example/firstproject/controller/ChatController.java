package com.example.firstproject.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.Member;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.ServletContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/chats")
public class ChatController {
    
    @Autowired
    private ServletContext application;

    @GetMapping("/")
    public String index() {
        //アプリケーションスコープからチャットリストを取得
        ArrayList<Member> chatList = (ArrayList<Member>)application.getAttribute("chatList");
        //チャットリストが存在しないなら初期化。
        if(chatList == null){
            chatList = new ArrayList<>();
        }
        //チャットリストをスコープに格納する。
        application.setAttribute("chatList", chatList);
        return "chats/chat-list";
    }

    @PostMapping("/post")
    public String postChat(Member member) {
         ArrayList<Object> chatList = (ArrayList<Object>)application.getAttribute("chatList");
        if(chatList == null){
            chatList = new ArrayList<>();
        }
        LocalDateTime now = LocalDateTime.now();
        member.setCreatedAt(now);
        //フォームで投稿した内容をチャットリストに追加。
        chatList.add(0,member);
        application.setAttribute("chatList", chatList);
        return "redirect:/chats/";
    }
    
    
}
