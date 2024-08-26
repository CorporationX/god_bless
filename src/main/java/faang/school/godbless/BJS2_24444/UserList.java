package faang.school.godbless.BJS2_24444;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private final List<User> userList = new ArrayList<>();

    public void addUser(User user) {
        userList.add(user);
        System.out.println("Пользователь " + user.getName() + " добавлен в список пользователей.");
    }
    public void getOnlineUsers() {
        List<User> onlineUsers = userList.stream()
                .filter(user -> !user.isOffline())
                .toList();
        System.out.println("Онлайн пользователи: " + onlineUsers);
    }
}
