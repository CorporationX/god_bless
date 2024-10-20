package school.faang.tinder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"isOnline", "isLookingForChat"})
public class User {
    private int userId;
    private String name;

    @Setter
    private boolean isOnline;

    @Setter
    private boolean isLookingForChat;

    @Override
    public String toString() {
        return userId + " : " + name;
    }
}
