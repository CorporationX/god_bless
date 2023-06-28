package faang.school.godbless.Multitrading2.MattersOfTheHeart;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static List<User> users = new ArrayList<>();

    public static void addUser(User user){
        users.add(user);
    }

    public static List<User> getOnlineUsers(){
        return users.stream()
                .filter(User::isOnline)
                .toList();
    }
}
