package school.faang.bjs2_81760;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of = {"name"})
@ToString(exclude = {"chat"})
public class User {
    private final String name;
    private boolean isOnline;
    private boolean isLookingForChat;
    private Chat chat;

    public User(String name) {
        this.name = name;
        this.isOnline = true;
        this.isLookingForChat = true;
    }

    public void switchChatStatus() {
        switchChatStatus(null);
    }

    public void switchChatStatus(Chat chat) {
        if (this.chat == null) {
            this.chat = chat;
            isLookingForChat = false;
        } else {
            this.chat = null;
            isLookingForChat = true;
        }
    }
}
