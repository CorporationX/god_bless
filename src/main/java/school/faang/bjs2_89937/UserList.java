package school.faang.bjs2_89937;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class UserList {
    private final List<User> users = new CopyOnWriteArrayList<>();

    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
            log.info("Добавлен пользователь: {}", user.getName());
        }
    }

    public void removeUser(User user) {
        if (users.remove(user)) {
            log.info("Удален пользователь: {}", user.getName());
        }
    }

    public List<User> getOnlineUsers() {
        List<User> onlineUsers = new ArrayList<>();
        for (User user : users) {
            if (user.isOnline() && user.isLookingForChat()) {
                onlineUsers.add(user);
            }
        }
        return onlineUsers;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}