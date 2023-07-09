package faang.school.godbless.kxnvg.tinder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String name;
    private Chat actualChat;
    private boolean isOnline;

    public User(String name) {
        this.name = name;
        actualChat = null;
        isOnline = false;
    }

    public void setOnline(boolean online) {
        isOnline = online;
        if (online) {
            UserList.addOnlineUser(this);
        } else {
            UserList.deleteOnlineUser(this);
        }
    }
}
