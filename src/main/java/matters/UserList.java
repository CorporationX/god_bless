package matters;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class UserList {
     private List<User> users = new ArrayList<>();

    public List<User > getOnlineUsers(){
        return users.stream().filter(User::isOnline).toList();
    }
    public void add(User user) {
        users.add(user);
    }

    public UserList(List<User> users) {
        this.users = users;
    }
}
