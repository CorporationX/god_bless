package derschrank.sprint03.task13.bjstwo_49141;

import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;

@Data
public class User {
    private final String name;
    private boolean isOnline;
    private boolean isActiveLookingForChat;
    private Chat hasChat;
    private User engageToUser;

    private ReentrantLock lock;


    public User(String name) {
        this(name, false);
    }

    public User(String name, boolean isActiveLookingForChat) {
        isOnline = true;
        this.name = name;
        this.isActiveLookingForChat = isActiveLookingForChat;
        lock = new ReentrantLock();
    }
    
    public synchronized boolean isAwaitForNewChat() {
        return isOnline && !isActiveLookingForChat && isNotEngaged() && isNotInChat();
    }

    public boolean engage(User user) {
        if (lock.tryLock() && isNotEngaged()) {
            engageToUser = user;
            lock.unlock();
            return true;
        }
        return false;
    }

    public boolean joinToChat(Chat chat, User withUser) {
        lock.lock();
        if (isEngagedToUser(withUser)) {
            isActiveLookingForChat = false;
            hasChat = chat;
            lock.unlock();
            return true;
        }
        lock.unlock();
        return false;
    }

    public void leaveFromChat() {
        lock.lock();
        hasChat = null;
        engageToUser = null;
        lock.unlock();
    }

    public void leaveFromEngage(User withUser) {
        lock.lock();
        if (isEngagedToUser(withUser)) {
            engageToUser = null;
        }
        lock.unlock();
    }

    public void changeEngage(User fromUser, User toUser) {
        lock.lock();
        if (isEngagedToUser(fromUser)) {
            engageToUser = toUser;
        }
        lock.unlock();
    }

    public boolean isNotEngaged() {
        return engageToUser == null;
    }

    public boolean isEngagedToUser(User user) {
        return engageToUser == user;
    }

    public boolean isNotInChat() {
        return hasChat == null;
    }

    @Override
    public String toString() {
        return name;
    }
}
