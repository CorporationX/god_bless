package faang.school.godbless.multithreading.matters_heart;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@EqualsAndHashCode
public class User {
    private String name;
    private boolean isOnline;
    @Setter
    private boolean isWantsToChat;

    public User(String name, boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
        isWantsToChat = false;
    }
}
