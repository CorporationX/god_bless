package school.faang.sprint3.bjs2_81809;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Chat {
    private ChatManager chatManager;
    private User user1;
    private User user2;

    public Chat(
            ChatManager chatManager,
            User user1,
            User user2
    ) {
        this.chatManager = chatManager;
        user1.setLookingForChat(false);
        user2.setLookingForChat(false);
        this.user1 = user1;
        this.user2 = user2;
    }

    public void closeChat() {
        chatManager.endChat(this);
    }
}
