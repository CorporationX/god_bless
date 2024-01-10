package Synchronization_7;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private static List<User> userList = new ArrayList<>();

    public static List<User> getOnlineUsers() {
        return userList
                .stream()
                .filter(user -> user.isOnline())
                .toList();
    }

    public static List<User> getReadyContactOnlineUsers() {
        return getOnlineUsers()
                .stream()
                .filter(user -> user.isReadyToContact())
                .toList();
    }

    public static List<User> getFemaleReadyContactUsers() {
        return getReadyContactOnlineUsers()
                .stream()
                .filter(user -> user.isSex().equals(Sex.FEMALE))
                .toList();
    }

    public static List<User> getMaleReadyContactUsers() {
        return getReadyContactOnlineUsers()
                .stream()
                .filter(user -> user.isSex().equals(Sex.MALE))
                .toList();
    }

    public static void addUser(User user) {
        userList.add(user);
    }

}
