package faang.school.godbless.synchronization.tynder;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {
    private final String name;
    private boolean isOnline;
    private boolean waitingForChat;
    private boolean isChatting;

    public User(String name) {
        this.name = name;
        isOnline = true;
        waitingForChat = false;
        isChatting = false;
    }

    public boolean isWaitingForChat() {
        return waitingForChat;
    }

    public void goOffline() {
        isOnline = false;
    }

    public void waitForChat() {
        waitingForChat = true;
    }

    public void stopChatting() {
        isChatting = false;
    }

    public void startChatting() {
        waitingForChat = false;
        isChatting = true;
    }
}
