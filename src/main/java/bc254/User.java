package bc254;

import lombok.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Value
public class User {
    String name;
    int age;
    String placeWork;
    String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            int age = user.age;

            if (groupUsers.containsKey(age))
                groupUsers.get(age).add(user);
            else {
                List<User> newGroup = new ArrayList<>();
                groupUsers.put(age, newGroup);
                newGroup.add(user);
            }
        }
        return groupUsers;
    }
}
