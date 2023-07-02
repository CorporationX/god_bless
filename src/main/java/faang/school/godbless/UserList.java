package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> users;
    public UserList() {
        this.users = new ArrayList<>();
    }
    public synchronized void addUser(User user) {
        users.add(user);
    }

    public synchronized void removeUser(User user){
        users.remove(user);
    }

    public synchronized List<User> getOnlineUsers() {
        List<User> onlineUsers =new ArrayList<>();
        for(User user : users){
            if(user.isOnline())
            {
                onlineUsers.add(user);
            }
        }
        return onlineUsers;
    }



}
