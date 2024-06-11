package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> ageGroups = new HashMap<>();

        for (User user : users) {
            if (ageGroups.containsKey(user.age)) {
                ageGroups.get(user.age).add(user);
            } else {
                ageGroups.put(user.age, new ArrayList<User>());
                ageGroups.get(user.age).add(user);
            }
        }
        return ageGroups;
    }
}
