package faang.school.godbless.tinder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode
public class User {
    private final String name;
    @Setter
    private boolean isOnline = false;

    public User(String name) {
        this.name = name;
    }
}
