package school.faang.bjs2_89919;

import lombok.Getter;

@Getter
public class User {
    private final String name;
    private boolean isOnline;
    private boolean isLookingForChat;
    private boolean isChatting;
    private Chat chat;

    public User(String name) {
        this.name = name;
        this.isOnline = true;
        this.isLookingForChat = true;
        this.isChatting = false;
        this.chat = null;
    }

    public synchronized boolean isOnline() {
        return isOnline;
    }

    public synchronized void setOnline(boolean online) {
        this.isOnline = online;
    }

    public synchronized boolean isLookingForChat() {
        return isLookingForChat;
    }

    public synchronized void setLookingForChat(boolean lookingForChat) {
        this.isLookingForChat = lookingForChat;
    }

    public synchronized boolean isChatting() {
        return isChatting;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
        this.isChatting = true;
    }

    public void resetChat() {
        this.chat = null;
        this.isChatting = false;
    }

    public Object getName() {
        return name;
    }
}