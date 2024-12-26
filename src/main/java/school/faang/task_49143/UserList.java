package school.faang.task_49143;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserList {
    private final List<User> users;

    public UserList() {
        this.users = new ArrayList<>();
    }

    public synchronized List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline)
                .collect(Collectors.toList());
    }

    public synchronized void addUser(User user) {
        users.add(user);
    }

    public synchronized void removeUser(User user) {
        users.remove(user);
    }
}
