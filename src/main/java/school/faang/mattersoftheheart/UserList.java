package school.faang.mattersoftheheart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserList {
    private final List<User> users = new ArrayList<>();

    public Optional<User> findCompanionForUser(User user) {
        return getOnlineUsers().stream()
                .filter(companion -> !companion.equals(user))
                .findFirst();
    }

    public List<User> getOnlineUsers() {
        return users.stream().filter(user -> user.isOnline() && user.isLookingForChat()).toList();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
