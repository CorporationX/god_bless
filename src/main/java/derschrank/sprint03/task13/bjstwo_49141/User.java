package derschrank.sprint03.task13.bjstwo_49141;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class User {
    private final String name;
    private boolean isOnline;
    private final AtomicBoolean isActiveLookingForChat;
    private Chat hasChat;
    private User engageToUser;
    private final AtomicLong hadChats;
    private final List<User> hadChatsWith;

    private final ReentrantLock lock;


    public User(String name) {
        this(name, false);
    }

    public User(String name, boolean isActiveLookingForChat) {
        isOnline = true;
        this.name = name;
        this.isActiveLookingForChat = new AtomicBoolean(isActiveLookingForChat);

        lock = new ReentrantLock();
        hadChats = new AtomicLong(0);
        hadChatsWith = new ArrayList<>();
    }
    
    public boolean isAwaitForNewChat() {
        return isOnline && isNotEngaged() && isNotInChat();
    }

    public boolean engage(User user) {
        if (lock.tryLock()) {
            if (isNotEngaged()) {
                engageToUser = user;
                lock.unlock();
                return true;
            }
            lock.unlock();
        }
        return false;
    }

    public boolean joinToChat(Chat chat, User withUser) {
        lock.lock();
        if (isEngagedToUser(withUser)) {
            hasChat = chat;
            hadChatsWith.add(withUser);
            lock.unlock();
            hadChats.incrementAndGet();
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

    public void setActiveLookingForChat(boolean flag) {
        isActiveLookingForChat.set(flag);
    }

    public boolean isActiveLookingForChat() {
        return isActiveLookingForChat.get();
    }

    @Override
    public String toString() {
        return name + " had count of chats: " + hadChats.get()
                + ", with: " + hadChatsWith.stream().map(User::getName).toList();
    }
}
