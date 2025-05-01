package school.faang.bjs2_73899;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private final List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public List<User> getOnlineUsers() {
        return users.stream()
            .filter(User::isOnline)
            .toList();
    }

    public List<User> getOtherOnlineUsersFrom(User user) {
        return users.stream()
            .filter(u -> !u.equals(user) && u.isOnline())
            .toList();
    }

    public List<User> getUsersReadyForChatFor(User user) {
        return users.stream()
            .filter(u -> !u.equals(user) && u.isOnline() && u.isLookingForChat() && !u.isInChat())
            .toList();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

}
