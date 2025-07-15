package school.faang.bjs2_81786;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private static GeneratorId generatorUserId = new GeneratorId(0);

    private final long id;
    private String name;
    private boolean isOnline;
    private boolean isLookingForChat;
    private boolean isChatting;
    @Setter(AccessLevel.NONE)
    private Chat chat;

    public User(String name, boolean isOnline, boolean isLookingForChat) {
        this.id = generatorUserId.nextId();
        this.name = name;
        this.isOnline = isOnline;
        this.isLookingForChat = isLookingForChat;
        this.isChatting = false;
        this.chat = null;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
        this.isChatting = true;
    }

    public void resetChat() {
        this.chat = null;
        this.isChatting = false;
    }

    public boolean isEligible() {
        return isOnline && isLookingForChat && !isChatting;
    }
}
