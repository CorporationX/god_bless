package faang.school.godbless.mattersoftheheart;

import lombok.Data;

@Data
public class User {
    private final String name;
    private boolean isWantToChat;
    private final ChatManager chatManager;

    public void startChat() {
        chatManager.startChat(this);
    }

    public void leaveFromChat() {
        chatManager.endChat(this);
    }
}
