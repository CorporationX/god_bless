package com.multithreading.matters;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Chat {
    private User firstUser;
    private User secondUser;

    public Chat(User firstUser, User secondUser) {
        this.firstUser = firstUser;
        this.secondUser = secondUser;
    }
}
