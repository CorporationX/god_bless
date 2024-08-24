package faang.school.godbless.BJS2_24312;

import lombok.*;

@Getter
@ToString
public class User {
    private String name;
    private boolean isOnline;
    private boolean isLookingForChat;
    private boolean isChatting;
    @ToString.Exclude
    private Chat chat;

    public User(String name, boolean isOnline, boolean isLookingForChat, boolean isChatting) {
        this.isChatting = isChatting;
        this.isLookingForChat = isLookingForChat;
        this.isOnline = isOnline;
        this.name = name;
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
