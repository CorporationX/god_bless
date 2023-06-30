package faang.school.godbless.mattersOfTheHeart;


import java.util.ArrayList;
import java.util.List;

public class UserList {
    public static List<User> allUsers = new ArrayList<>();

    public List<User> getOnlineUsers(){
        return allUsers.stream().filter(User::getIsOnline).toList();
    }


}
