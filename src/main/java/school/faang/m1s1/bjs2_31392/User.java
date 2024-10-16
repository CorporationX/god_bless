package school.faang.m1s1.bjs2_31392;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String company;
    private String workAddress;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> ageGroups = new HashMap<>();

        for (User user : userList) {
            ageGroups.computeIfAbsent(user.getAge(), key -> new ArrayList<>()).add(user);
        }

        return ageGroups;
    }
}
