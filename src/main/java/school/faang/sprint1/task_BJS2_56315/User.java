package school.faang.sprint1.task_BJS2_56315;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();

        for (User user : users) {
            usersByAge.computeIfAbsent(user.age, k -> new ArrayList<>());
            usersByAge.get(user.age).add(user);
        }
        return usersByAge;
    }
}
