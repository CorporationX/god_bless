package faang.school.godbless.mattersOfTheHeart;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class User {
    private String name;
    private boolean isOnline;
    private boolean isWantChat;

    public User(String name, boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
        this.isWantChat = false;
        UserList.addUser(this);
    }
}
