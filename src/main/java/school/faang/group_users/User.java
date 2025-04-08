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
        Map<Integer, List<User>> groupedUsersByAge = new HashMap<>();
        for (User user : users) {
            groupedUsersByAge.putIfAbsent(user.getAge(), new ArrayList<>());
            groupedUsersByAge.get(user.getAge()).add(user);
        }
        return groupedUsersByAge;
    }
}
