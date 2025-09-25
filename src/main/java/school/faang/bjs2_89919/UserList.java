package school.faang.bjs2_89919;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class UserList {
    private final List<User> users = new ArrayList<>();
    private final Object monitor;

    public void addUser(User user) {
        synchronized (monitor) {
            users.add(user);
        }
    }

    public void removeUser(User user) {
        synchronized (monitor) {
            users.remove(user);
        }
    }

    public synchronized List<User> getOnlineUsersLookingForChat(User user) {
        return users.stream()
                .filter(u -> u.isOnline() && u.isLookingForChat() && !u.equals(user) && !u.isChatting())
                .toList();
    }
}