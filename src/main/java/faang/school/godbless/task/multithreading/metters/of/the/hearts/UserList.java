package faang.school.godbless.task.multithreading.metters.of.the.hearts;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserList {
    private final Map<Long, User> onlineUsers = new HashMap<>();

    public List<User> getOnlineUsers() {
        synchronized (this) {
            return Collections.unmodifiableList(new CopyOnWriteArrayList<>(onlineUsers.values()));
        }
    }

    public void addOnlineUser(User user) {
        synchronized (this) {
            onlineUsers.put(user.getId(), user);
        }
    }

    public void removeOnlineUser(User user) {
        synchronized (this) {
            onlineUsers.remove(user.getId());
        }
    }
}
