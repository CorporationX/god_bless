package school.faang.task_61509;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class User {
    private final String name;
    @Setter
    private boolean isOnline;
    @Setter
    private boolean isLookingForChat;
    @Setter
    private boolean isChatting;
    private boolean isEligible;
    @Setter
    private Chat chat;

    public User(String name, boolean isOnline, boolean isLookingForChat, boolean isChatting) {
        this.name = name;
        this.isOnline = isOnline;
        this.isLookingForChat = isLookingForChat;
        this.isChatting = isChatting;
    }

    public boolean isEligible() {
        return isOnline && isLookingForChat && !isChatting;
    }
}
