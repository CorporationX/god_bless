package school.faang;

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
    private String company;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroupsByAge = new HashMap<>();
        users.forEach(user -> userGroupsByAge
                .computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user));
        return userGroupsByAge;
    }
}
