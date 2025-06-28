package school.faang.module1.bjs2_81781;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private final List<User> users = new ArrayList<>();

    public synchronized List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isAvailable)
                .toList();
    }

    public synchronized void addUser(User user) {
        users.add(user);
    }

    public synchronized void removeUser(User user) {
        users.remove(user);
    }
}