package Sprint_4_Task22;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
public class UserList {
    List<User> userList;

    public List<User> getOnlineUsers() {
        List<User> usersOnline = new ArrayList<>();
        for (User user : userList) {
            if (user.isOnline()) {
                usersOnline.add(user);
            }
        }
        return usersOnline;
    }
}
