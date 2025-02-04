package school.faang.usergrouping;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        List<User> usersByAge;
        for (User user : users) {
            if (groupedUsers.containsKey(user.getAge())) {
                usersByAge = groupedUsers.get(user.getAge());
                if (!usersByAge.contains(user)) {
                    usersByAge.add(user);
                }
            } else {
                usersByAge = new ArrayList<>();
                usersByAge.add(user);
                groupedUsers.put(user.getAge(), usersByAge);
            }
        }
        return groupedUsers;
    }
}
