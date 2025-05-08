package school.faang.stream3.mattersoftheheart;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private final List<User> userList = new ArrayList<>();

    public List<User> getOnlineUsers() {
        return userList.stream()
                .filter(User::isOnline)
                .toList();
    }

    public List<User> getChatReadyUsers() {
        return getOnlineUsers().stream()
                .filter(User::isLookingForChat)
                .toList();
    }

    public boolean addUser(User user) {
        return userList.add(user);
    }

    public boolean removeUser(User user) {
        return userList.remove(user);
    }
}
