package school.faang.user_group_by_age;

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
        Map<Integer, List<User>> usersGroupByAge = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            if (!usersGroupByAge.containsKey(age)) {
                usersGroupByAge.put(age, new ArrayList<>());
            }
            usersGroupByAge.get(age).add(user);
        }

        return usersGroupByAge;
    }
}
