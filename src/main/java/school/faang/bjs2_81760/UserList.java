package school.faang.bjs2_81760;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserList {
    private List<User> users = new ArrayList<>();

    public synchronized List<User> getOnlineUsers(User currentUser) {
        return Optional.ofNullable(users)
                .map(users -> users.stream()
                        .filter(user -> !user.equals(currentUser) && user.isOnline() && user.isLookingForChat())
                        .toList())
                .orElse(Collections.emptyList());
    }

    public synchronized void addUser(User user) {
        users.add(user);
    }

    public synchronized void removeUser(User user) {
        users.remove(user);
    }

    public synchronized List<User> getUsers() {
        return users;
    }
}
