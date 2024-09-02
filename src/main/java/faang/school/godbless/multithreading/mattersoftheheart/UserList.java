package faang.school.godbless.multithreading.mattersoftheheart;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private final List<User> userList = new ArrayList<>();

    public void addUser(User user) {
        userList.add(user);
        System.out.printf("> user %s added to list%n", user.getName());
    }

    public void getOnlineUsers() {
        List<User> onlineUsers = userList.stream()
                .filter(user -> !user.isOffline())
                .toList();

        System.out.println("> online users: " + onlineUsers);
    }

}
