package faang.school.godbless.BJS224391;

import java.util.LinkedList;
import java.util.List;

public class UserList {
    private static List<User> users;

    public static LinkedList<User> getOnlineUsers(){
        return (LinkedList<User>) users;
    }
}
