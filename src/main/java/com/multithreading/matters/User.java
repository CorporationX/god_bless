package com.multithreading.matters;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class User {
    private String name;
    private boolean isOnline = false;

    public User(String name) {
        this.name = name;
    }
}
