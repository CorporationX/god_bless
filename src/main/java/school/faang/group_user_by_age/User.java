package school.faang.group_user_by_age;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private final String name;
    private int age;
    private String company;
    private String address;

    static Map<Integer, List<User>> groupUsers(List<User> users) {
        var groupedUsers = new HashMap<Integer, List<User>>();
        users.forEach(user -> groupedUsers.put(user.getAge(), users.stream()
                .filter(p -> p.age == user.getAge()).toList()));

        return groupedUsers;
    }
}
