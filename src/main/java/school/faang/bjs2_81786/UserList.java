package school.faang.bjs2_81786;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class UserList {
    private Set<User> users = new HashSet<>();

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline)
                .toList();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
