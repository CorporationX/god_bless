package TinderFeature;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class UserList {
    final static List<User> users = new ArrayList<>();
    public static void addUser(User user) {
        users.add(user);
    }
    public static void removeUser(User user) {
        users.remove(user);
    }

    public static List<User> getOnlineUsers(List<User> userList){
        Map<Boolean,List<User>> activeUsers = userList.stream()
                .collect(Collectors.partitioningBy(User::isActive));
        List<User> getOnlineUsers = activeUsers.get(true);
        return getOnlineUsers;
    }
}
