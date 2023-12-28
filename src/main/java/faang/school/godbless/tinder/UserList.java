package faang.school.godbless.tinder;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> users;

    public UserList() {
        this.users = new ArrayList<>();
    }

    void addUser(User user){
        users.add(user);
    }

    List<User> getOnlineUsers(){
        return users.stream().filter(User::isOnline).toList();
    }
}
