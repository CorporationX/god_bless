package faang.school.godbless.BJS224391;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> users;

    public UserList() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public User getOnlineUser(User user) {
        return users.stream()
                .filter(userFromList -> !userFromList.equals(user))
                .filter(userFromList -> userFromList.isOnline() && userFromList.isLookingForChat() && !userFromList.isChatting())
                .findAny().orElse(null);
    }
}
