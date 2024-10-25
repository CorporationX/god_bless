package school.faang.godbless.bjs2_37506;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private final List<User> users = new ArrayList<>();

    public UserList(List<User> users) {
        this.users.addAll(users);
    }

    public synchronized List<User> getOnlineUsers() {
        return users.stream().filter(User::isOnline).toList();
    }

    public synchronized void addUser(@NonNull User user) {
        users.add(user);
    }

    public synchronized boolean removeUser(User user) {
        return users.remove(user);
    }
}
