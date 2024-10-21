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

    private boolean isLookingForChat;

    public void switchLookingForChat() {
        isLookingForChat = !isLookingForChat;
    }

    public boolean isInterlocutorCandidate(User user) {
        return !this.equals(user) && user.isLookingForChat() && user.isOnline;
    }

    @Override
    public String toString() {
        return userId + " : " + name;
    }
}
