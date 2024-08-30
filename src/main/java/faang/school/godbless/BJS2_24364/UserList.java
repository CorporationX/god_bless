package faang.school.godbless.BJS2_24364;

import java.util.ArrayList;
import java.util.List;


public class UserList {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline)
                .toList();
    }
}
