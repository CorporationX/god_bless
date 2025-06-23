package school.faang.sprint3.bjs2_81809;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private final List<User> list = new ArrayList<>();

    public void removeUser(User user) {
        list.remove(user);
    }

    public void addUser(User user) {
        list.add(user);

    }

    public List<User> getOnlineUsers() {
        return list.stream()
                .filter(User::isOnline)
                .toList();
    }

    public long getLookingForChatUsersCount(User except) {
        return list.stream()
                .filter(User::isLookingForChat)
                .filter(user -> !user.equals(except))
                .count();
    }

    public List<User> getLookingForChatUsers(int limit, User except) {
        return list.stream()
                .filter(user -> !user.equals(except))
                .limit(limit)
                .toList();
    }

    public List<User> get() {
        return list;
    }
}
