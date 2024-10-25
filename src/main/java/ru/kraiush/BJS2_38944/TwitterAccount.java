package ru.kraiush.BJS2_38944;

import lombok.Data;

@Data
public class TwitterAccount {
    private String username;
    private int followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = 0;
    }
}
