package school.faang.matters_of_the_heart;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private String name;
    private boolean isOnline;
    private boolean isLookingForChat;

    public User(String name) {
        this.name = name;
        this.isOnline = true;
        this.isLookingForChat = false;
    }
}
