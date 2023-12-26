package com.example.firstproject.form;

import java.time.LocalDate;
import java.util.List;

public class MemberForm {
        //名前
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
    private List<Integer> hobbyList;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public Integer getMoney()
    {
        return money;
    }

    public void setMoney(Integer money)
    {
        this.money = money;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public LocalDate getBirthDay()
    {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay)
    {
        this.birthDay = birthDay;
    }

    public List<Integer> getHobbyList()
    {
        return hobbyList;
    }

    public void setHobbyList(List<Integer> hobbyList)
    {
        this.hobbyList = hobbyList;
    }

}
