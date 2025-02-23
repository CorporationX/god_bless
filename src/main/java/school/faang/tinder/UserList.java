package school.faang.tinder;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class UserList {
    private final Set<User> users = new HashSet<>();
    private final Set<User> usersIsOnline = new HashSet<>();
    private final Set<User> usersIsLookingForChat = new HashSet<>();

    public void add(User user) {
        users.add(user);
        switchOnOffLine(user);
    }

    public void remove(User user) {
        users.remove(user);
        usersIsOnline.remove(user);
        usersIsLookingForChat.remove(user);
    }

    public void switchOnOffLine(User user) {
        if (changeState(usersIsOnline, user)) {
            user.setOnline(true);
        } else {
            user.setOnline(false);
        }
    }

    public void switchLookingForChat(User user) {
        if (changeState(usersIsLookingForChat, user)) {
            user.setLookingForChat(true);
        } else {
            user.setLookingForChat(false);
        }
    }

    private boolean changeState(Set<User> users, User user) {
        if (!users.remove(user)) {
            users.add(user);
            return true;
        } else {
            return false;
        }
    }

}
