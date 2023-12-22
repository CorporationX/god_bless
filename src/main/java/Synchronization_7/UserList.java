package Synchronization_7;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private static List<User> userList = new ArrayList<>();

    public static List<User> getOnlineUsers() {
        return userList.stream().filter(user -> user.isOnline() == true).toList();
    }

    public static List<User> getReadyContactOnlineUsers() {
        return getOnlineUsers().stream().filter(user -> user.isReadyToContact() == true).toList();
    }

    public static List<User> getFemaleReadyContactUsers() {
        return getReadyContactOnlineUsers().stream().filter(user -> user.isSex() == true).toList();
    }

    public static List<User> getMaleReadyContactUsers() {
        return getReadyContactOnlineUsers().stream().filter(user -> user.isSex() == false).toList();
    }

    public static void addUser(User user) {
        userList.add(user);
    }

}
