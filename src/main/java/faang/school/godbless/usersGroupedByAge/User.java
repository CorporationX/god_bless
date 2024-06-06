package faang.school.godbless.usersGroupedByAge;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> targetUsers) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : targetUsers) {
            List<User> users = groupedUsers.containsKey(user.age) ? groupedUsers.get(user.age) : new ArrayList<>();

            users.add(user);

            groupedUsers.put(user.age, users);
        }

        return groupedUsers;
    }
}
