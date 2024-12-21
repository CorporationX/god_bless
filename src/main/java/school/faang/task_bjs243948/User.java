package school.faang.task_bjs243948;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private int address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsersResult = new HashMap<>();
        for (User user : users) {
            if (!groupUsersResult.containsKey(user.age)) {
                groupUsersResult.put(user.age, new ArrayList<>());
            }
            groupUsersResult.get(user.age).add(user);
        }
        return groupUsersResult;
    }
}
