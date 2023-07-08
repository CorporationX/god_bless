package Sprint_4_Task22;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data

public class UserList {
    private List<User> userList = new ArrayList<>();


    public List<User> getOnlineUsers(User users) {
        return userList.stream()
                .filter(user -> !user.getAllIsChatting() && !user.equals(users))
                .toList();
    }
    public void addUser(User user){
        userList.add(user);
    }
    public List<User> getOnlineUsers(){
        return userList;
    }
}
