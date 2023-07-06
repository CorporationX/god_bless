package faang.school.godbless.multithreading.matters_heart;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User {
    private String name;
    private boolean isOnline;
    private boolean isWantsToChat;
    private Chat chat;

    public User(String name, boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
    }
}
