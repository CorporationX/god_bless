package faang.school.godbless.javaCore.groupUsersByAge;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groups = new HashMap<>();
        for (User user : users) {
            if (groups.containsKey(user.age)) {
                groups.get(user.age).add(user);
            } else {
                groups.put(user.age, new ArrayList<>(Arrays.asList(user)));
            }
        }
        return groups;
    }
}