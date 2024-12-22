package school.faang.sprint_3.task_49494;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class UserList {
    private final List<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    public List<User> getOnlineUser() {
        return users.parallelStream()
                .filter(user -> user.isOnline() && user.isLookingForChat())
                .toList();
    }

    public synchronized void addUser(User user) {
        ValidationUtils.isNotNull(user, "Пользователь");
        users.add(user);
    }

    public synchronized void removeUser(User user) {
        ValidationUtils.isNotNull(user, "Пользователь");
        users.removeIf(user::equals);
    }

}
