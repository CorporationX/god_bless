package school.faang.mattersoftheheart;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> users = new ArrayList<>();

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline)
                .filter(User::isLookingForChat)
                .toList();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}