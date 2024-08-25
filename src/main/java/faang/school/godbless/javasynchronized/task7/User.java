package faang.school.godbless.javasynchronized.task7;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;

    public User(String name, boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
    }

    private boolean isOnline;
    private Chat chat;
}
