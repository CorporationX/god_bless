package school.faangSprint3.t11;

import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

@Getter
public class User {
    private String name;
    private volatile boolean isOnline;
    private volatile boolean isLookingForChat;
    private final ReentrantLock lock = new ReentrantLock();

    public User(String name) {
        this.name = name;
        this.isOnline = false;
        this.isLookingForChat = false;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        lock.lock();
        try {
            isOnline = online;
        } finally {
            lock.unlock();
        }
    }

    public boolean isLookingForChat() {
        return isLookingForChat;
    }

    public void setLookingForChat(boolean lookingForChat) {
        lock.lock();
        try {
            isLookingForChat = lookingForChat;
        } finally {
            lock.unlock();
        }
    }
}