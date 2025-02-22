package school.faang.tinder;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserList {

    private final List<User> users = new ArrayList<>();

    public List<User> getOnlineUsers() {
        return users.stream().filter(User::isOnline).filter(User::isLookingForChat).toList();
    }

    public void addUser(User user) {
        if (user == null) {
            log.warn("Передан пустой пользователь");
            return;
        }
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    public void removeUser(User user) {
        if (user == null) {
            log.warn("Поле user пустое. Удаление невозможно");
            return;
        }
        users.remove(user);
    }
}
