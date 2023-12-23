package faang.school.godbless.tinder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class User {
    private String name;
    boolean isOnline;
    boolean isWantTalk;

    public User(String name, boolean isOnline, boolean isWantTalk) {
        this.name = name;
        this.isOnline = isOnline;
        this.isWantTalk = isWantTalk;
    }
}
