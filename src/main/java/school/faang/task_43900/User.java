package school.faang.task_43900;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupByAge = new HashMap<>();
        for (User user : users) {
            groupByAge.computeIfAbsent(user.age, k -> new ArrayList<User>()).add(user);
        }
        return groupByAge;
    }
}
