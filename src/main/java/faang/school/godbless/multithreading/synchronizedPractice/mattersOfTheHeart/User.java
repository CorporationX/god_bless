package faang.school.godbless.multithreading.synchronizedPractice.mattersOfTheHeart;

import lombok.Getter;
import lombok.Setter;

@Getter
public class User {
    private final String name;
    private final boolean isOnline;
    private final boolean wantsToChat;
    private final boolean wantsToShowOnline;
    private boolean isChatting;
    @Setter
    private Chat chat;

    public User(String name, boolean isOnline, boolean wantsToChat, boolean wantsToShowOnline, boolean isChatting) {
        this.name = name;
        this.isOnline = isOnline;
        this.wantsToChat = wantsToChat;
        this.wantsToShowOnline = wantsToShowOnline;
        this.isChatting = isChatting;
        this.chat = null;
    }

    public void resetChat() {
        this.chat = null;
        this.isChatting = false;
    }

    public boolean isEligible() {
        return isOnline && wantsToChat && wantsToShowOnline && !isChatting;
    }
}
