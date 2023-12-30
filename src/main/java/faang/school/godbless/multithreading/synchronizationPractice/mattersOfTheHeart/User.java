package faang.school.godbless.multithreading.synchronizationPractice.mattersOfTheHeart;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode
public class User {
    private final String name;
    private final boolean isOnline;
    @Setter
    private boolean wantsToChat;
//    private final boolean wantsToShowOnline;
    @Setter
    private boolean isChatting;

    public User(String name, boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
//        this.wantsToChat = wantsToChat;
//        this.wantsToShowOnline = wantsToShowOnline;
//        this.isChatting = isChatting;
    }

    public void resetChat() {
        this.isChatting = false;
    }

    public boolean isEligible() {
        return isOnline && wantsToChat && !isChatting;
    }
}
