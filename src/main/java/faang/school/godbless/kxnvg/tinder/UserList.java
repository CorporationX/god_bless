package faang.school.godbless.kxnvg.tinder;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private static  final List<User> ALL_USERS = new ArrayList<>();
    private static final List<User> ONLINE_USERS = new ArrayList<>();

    public static void addUser(User user) {
        ALL_USERS.add(user);
    }

    public static boolean deleteUser(User user) {
        if (ALL_USERS.contains(user)) {
            ALL_USERS.remove(user);
            return true;
        }
        return false;
    }

    public static List<User> getAllUsers() {
        return ALL_USERS;
    }

    public static void addOnlineUser(User user) {
        ONLINE_USERS.add(user);
    }

    public static List<User> getOnlineUsers() {
        return ONLINE_USERS;
    }

    public static boolean deleteOnlineUser(User user) {
        if (ONLINE_USERS.contains(user)) {
            ONLINE_USERS.remove(user);
            return true;
        }
        return false;
    }
}
