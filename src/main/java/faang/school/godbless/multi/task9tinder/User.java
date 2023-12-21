package faang.school.godbless.multi.task9tinder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private boolean isOnline = true;
    private boolean isAvailableForChat = false;

    public User(String name) {
        this.name = name;
    }
}
