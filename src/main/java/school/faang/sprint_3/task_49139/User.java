package school.faang.sprint_3.task_49139;

import lombok.Data;

@Data
public class User {
    private final String name;
    private boolean isOnline = true;
    private boolean isLookingForChat = true;
    private Chat chat;

    public void setChat(Chat chat) {
        this.chat = chat;
        isLookingForChat = false;
    }

    public void resetChat() {
        chat = null;
        isLookingForChat = true;
    }
}
