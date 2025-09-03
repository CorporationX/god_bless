package school.faang.task3;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();

            if (result.containsKey(age)) {
                result.get(age).add(user);
            } else {
                List<User> newUsers = new ArrayList<>();
                newUsers.add(user);
                result.put(age, newUsers);
            }
        }
        return result;
    }
}
