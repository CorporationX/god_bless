package school.faangSprint3.t11;

import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

@Getter
public class User {
    private final String name;
    private volatile boolean isOnline;
    private volatile boolean isLookingForChat;

    public User(String name) {
        this.name = name;
        this.isOnline = false;
        this.isLookingForChat = false;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public synchronized void setOnline(boolean online) {
        isOnline = online;
    }

    public boolean isLookingForChat() {
        return isLookingForChat;
    }

    public synchronized void setLookingForChat(boolean lookingForChat) {
        isLookingForChat = lookingForChat;
    }
}