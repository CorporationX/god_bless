package users.group.by.age;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data
public class User {
    private final String name;
    private final String workPlace;
    private final String address;
    private final int age;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            if (groupedUsers.containsKey(user.age)) {
                groupedUsers.get(user.age).add(user);
            } else {
                List<User> oneUserinList = new LinkedList<>();
                users.add(user);
                groupedUsers.put(user.age, oneUserinList);
            }
        }

        return groupedUsers;
    }
}
