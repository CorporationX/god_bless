package faang.school.godbless.synchronization.task_7.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class User {
    private final String name;
    private boolean online;
    private boolean waitingForChat;
    private Integer chatId;

    public User(String name) {
        this.name = name;
        online = true;
        waitingForChat = true;
    }

    public void disconnect() {
        online = false;
    }

    public void waitForChat() {
        waitingForChat = true;
    }

    public void startChatting(int chatId) {
        this.chatId = chatId;
        waitingForChat = false;
    }

    public void leaveTheChat(int chatId) {
        this.chatId = 0;
        waitForChat();
    }
}