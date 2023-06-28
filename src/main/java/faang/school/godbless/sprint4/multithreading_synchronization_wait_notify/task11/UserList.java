package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task11;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> onlineUsers;

    public UserList() {
        this.onlineUsers = new ArrayList<>();
    }

    public List<User> getOnlineUsers() {
        return onlineUsers;
    }

    public void addOnlineUser(User user) {
        onlineUsers.add(user);
    }

    public void deleteOfflineUser() {
        onlineUsers.removeIf(user -> !user.isOnline());
    }
}
