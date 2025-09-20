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

    public synchronized List<User> getOnlineUsersLookingForChat() {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.isOnline() && user.isLookingForChat()) {
                result.add(user);
            }
        }
        return result;
    }
}