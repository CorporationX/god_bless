package faang.school.godbless.sprint3.matters_of_the_heart;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static final List<User> userList = new ArrayList<>();
    public void addUser(User user) {
        userList.add(user);
    }

    public void removeUser(User user) {
        userList.remove(user);
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
