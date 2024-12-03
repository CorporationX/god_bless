package school.faang.task_43960;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        var groupedUsers = new HashMap<Integer, List<User>>();

        for (var user : users) {
            var age = user.getAge();
            var usersWithSameAge = groupedUsers.getOrDefault(age, new ArrayList<User>());
            usersWithSameAge.add(user);
            groupedUsers.put(age, usersWithSameAge);
        }

        return groupedUsers;
    }
}
