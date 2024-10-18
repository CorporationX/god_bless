package school.faangSprint3.t11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserList {
    private final List<User> users = Collections.synchronizedList(new ArrayList<>());

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(user -> user.isOnline() && user.isLookingForChat())
                .toList();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}