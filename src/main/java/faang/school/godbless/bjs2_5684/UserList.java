package faang.school.godbless.bjs2_5684;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    // Возвращает список пользователей онлайн.
    public List<User> getOnlineUsers() {
        return users.stream().filter(User::isOnline).toList();
    }
}
