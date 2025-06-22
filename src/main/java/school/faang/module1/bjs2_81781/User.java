package school.faang.module1.bjs2_81781;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    private final String name;
    private boolean isOnline;
    private boolean isLookingForChat;

    public User(String name) {
        this.name = name;
        this.isOnline = false;
        this.isLookingForChat = false;
    }

    public boolean isAvailable() {
        return isOnline && isLookingForChat;
    }
}