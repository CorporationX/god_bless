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

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            List<User> usersList = groupedUsers.containsKey(user.age) ? groupedUsers.get(user.age) : new ArrayList<>();

            usersList.add(user);

            groupedUsers.put(user.age, usersList);
        }

        return groupedUsers;
    }
}
