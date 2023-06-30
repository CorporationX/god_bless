package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task11;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private final List<User> onlineUsers;

    public UserList() {
        this.onlineUsers = new ArrayList<>();
    }

    public List<User> getOnlineUsers() {
        deleteOfflineUser();
        return onlineUsers;
    }

    public void addOnlineUser(User user) {
        onlineUsers.add(user);
    }

    public void deleteOfflineUser() {
        onlineUsers.removeIf(user -> !user.isOnline());
//        onlineUsers.forEach(System.out::println);
    }
}
