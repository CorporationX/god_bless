package school.faang.bjs2_89919;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class UserList {
    private final List<User> users = new ArrayList<>();
    private final List<User> searchingUsers = new ArrayList<>();
    private final Object monitor;

    void addUser(User user) {
        users.add(user);
    }

    void removeUser(User user) {
        users.remove(user);
        searchingUsers.remove(user);
    }

    void addToSearching(User user) {
        if (!searchingUsers.contains(user)) {
            searchingUsers.add(user);
        }
    }

    public List<User> getOnlineUsersLookingForChat(User user) {
        return users.stream()
                .filter(u -> u.isOnline() && u.isLookingForChat() && !u.equals(user) && !u.isChatting())
                .toList();
    }
}