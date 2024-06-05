package faang.school.godbless.javaCore.groupUsersByAge;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
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
            List<User> sameAgeUsers = groups.get(user.age);
            if (sameAgeUsers == null) {
                sameAgeUsers = new ArrayList<>();
            }
            sameAgeUsers.add(user);
            groups.put(user.age, sameAgeUsers);
        }
        return groups;
    }
}