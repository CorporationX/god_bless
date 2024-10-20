package school.faang.m1s3.bjs2_37459_tinder;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserList {
    private List<User> userList = new ArrayList<>();

    public List<User> getOnlineUsers() {
        return userList.stream()
                .filter(u -> u.isOnline() && u.isLookingForChat())
                .toList();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void removeUser(User user) {
        userList.remove(user);
    }


}
