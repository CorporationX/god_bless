package faang.school.godbless.BJS2_24418;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@Setter
@ToString
public class User {
    private final int userId;
    private final String name;
    private boolean isOnline;
    private boolean isChatting = false;
    private boolean wantToChat;
    private Chat chat;

    public User(int userId, String name, boolean isOnline, boolean wantToChat) {
        this.userId = userId;
        this.name = name;
        if (!isOnline) {
            this.wantToChat = false;
        } else {
            this.wantToChat = wantToChat;
        }
        this.isOnline = isOnline;
    }
}
