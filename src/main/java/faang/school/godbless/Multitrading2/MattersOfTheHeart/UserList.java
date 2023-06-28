package faang.school.godbless.Multitrading2.MattersOfTheHeart;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static final List<User> userList = new ArrayList<>();

    public void addUser(User user) {
        userList.add(user);
    }

    public static List<User> getOnlineUsers() {
        List<User> onlineUsers = new ArrayList<>();
        for (User user : userList) {
            if (user.isOnline()) {
                onlineUsers.add(user);
            }
        }
        return onlineUsers;
    }
}
