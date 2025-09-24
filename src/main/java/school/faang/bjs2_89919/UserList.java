package school.faang.bjs2_89919;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private final List<User> users = new ArrayList<>();

    public synchronized void addUser(User user) {
        users.add(user);
    }

    public synchronized void removeUser(User user) {
        users.remove(user);
    }

    public synchronized List<User> getOnlineUsersLookingForChat(User user) {
        return users.stream()
                .filter(u -> u.isOnline() && u.isLookingForChat() && !u.equals(user) && !u.isChatting())
                .toList();
    }
}