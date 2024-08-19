package com.functional.mistakes;

public class Email {
    private String name;
    private int password;
    public Email(String name, int password) {
        //Пробрасываю ошибку для иллюстрации
        if(name.isEmpty()){
            throw new IllegalArgumentException("The name is empty. Check the value of the name field");
        }
        this.name = name;
        this.password = password;
    }
}
