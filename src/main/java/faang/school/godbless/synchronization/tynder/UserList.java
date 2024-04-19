package faang.school.godbless.synchronization.tynder;

import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.synchronization.tynder.ChatManager.userCheck;

public class UserList {
    private final List<User> users = new ArrayList<>();

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline)
                .toList();
    }

    public void addUser(User user) {
        userCheck(user);

        users.add(user);
    }
}
