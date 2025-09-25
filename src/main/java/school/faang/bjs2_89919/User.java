package school.faang.bjs2_89919;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter
public class User {
    private final String name;
    private boolean isOnline;
    private boolean isLookingForChat;
    private boolean isChatting;
    private Optional<Chat> chat;

    public User(String name) {
        this.name = name;
        this.isOnline = true;
        this.isLookingForChat = true;
        this.isChatting = false;
        this.chat = Optional.empty();
    }

    public void setChat(Chat chat) {
        this.chat = Optional.ofNullable(chat);
        this.isChatting = true;
    }

    public void resetChat() {
        this.chat = Optional.empty();
        this.isChatting = false;
    }
}