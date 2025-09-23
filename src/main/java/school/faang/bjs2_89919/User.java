package school.faang.bjs2_89919;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class User {
    private String name;
    private volatile boolean isOnline;
    private volatile boolean isLookingForChat;
    private volatile boolean isChatting;

    public User(String name) {
        this.name = name;
        this.isOnline = false;
        this.isLookingForChat = false;
    }

    public synchronized boolean isOnline() {
        return isOnline;
    }

    public synchronized void setOnline(boolean online) {
        isOnline = online;
    }

    public synchronized boolean isLookingForChat() {
        return isLookingForChat;
    }

    public void setChat() {
        this.chat = chat;
        this.isChatting = true;
    }

    public void resetChat() {
        this.chat = null;
        this.isChatting = false;
    }
}