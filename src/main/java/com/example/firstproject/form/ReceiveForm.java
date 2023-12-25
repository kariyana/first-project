package com.example.firstproject.form;

public class ReceiveForm {
    //名前
    private String name;
    //年齢
    private String age;
    //メールアドレス
    private String email;
    //年齢
    private String pass;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAge(){
        return age;
    }

    public void setAge(String age){
        this.age = age;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getPass(){
        return pass;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
