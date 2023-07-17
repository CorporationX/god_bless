package faang.school.godbless.multithreading.heart_matters;

import lombok.Getter;

@Getter
public class User {
    private long id;
    private String name;
    private boolean isOnline;
    private boolean wantsToChat;

    public User(long id, String name, boolean isOnline) {
        this.id = id;
        this.name = name;
        this.isOnline = isOnline;
    }

    public void setWantsToChat(boolean wantsToChat) {
        this.wantsToChat = wantsToChat;
    }
}
