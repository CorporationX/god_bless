package school.faang.group_users;


import lombok.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {

    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            if (userGroups.containsKey(user.getAge())) {
                List<User> usersWithSameAge = userGroups.get(user.getAge());
                usersWithSameAge.add(user);
            } else {
                List<User> newList = new ArrayList<>();
                newList.add(user);
                userGroups.put(user.getAge(), newList);
            }
        }
        return userGroups;
    }
}
