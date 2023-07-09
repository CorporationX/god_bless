package Multithreading.bc3012;

import lombok.Data;

@Data
public class User {
    private String name;
    private boolean isOnline;

    public User(String name) {
        this.name = name;
        this.isOnline = true;
    }
}
