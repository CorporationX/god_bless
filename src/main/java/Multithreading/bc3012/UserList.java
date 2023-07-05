package Multithreading.bc3012;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public List<User> getOnlineUsers() {
        List<User> usersOnline = new ArrayList<>();
        for (User user : users) {
            if (user.isOnline()) {
                usersOnline.add(user);
            }
        }
        return usersOnline;
    }
}
