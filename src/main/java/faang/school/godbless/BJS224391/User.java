package faang.school.godbless.BJS224391;

import lombok.Getter;

@Getter
public class User {
    private String name;
    private boolean isOnline;
    private boolean isLookingForChat;
    private boolean isChatting;
    private Chat chat;

    public User(String name, boolean isOnline, boolean isLookingForChat) {
        this.name = name;
        this.isOnline = isOnline;
        this.isLookingForChat = isLookingForChat;
        this.isChatting = false;
        chat = null;
    }

    public void connectToChat(Chat chat) {
        this.chat = chat;
        this.isChatting = true;
    }

    public void disconnectFromChat() {
        this.chat = null;
        this.isChatting = false;
    }
}
