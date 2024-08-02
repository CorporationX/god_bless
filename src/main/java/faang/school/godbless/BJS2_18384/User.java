package faang.school.godbless.BJS2_18384;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String placeWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> ageGroups = new HashMap<>();

        for (User user : users) {
            List<User> count = ageGroups.getOrDefault(user.age, new ArrayList<>());
            count.add(user);
            ageGroups.put(user.age, count);
        }

        return ageGroups;
    }
}
