package school.faang.usergrouping;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;


    public static Map<Integer, List<User>> groupUsers(List<User> usersList) {
        Map<Integer, List<User>> users = new HashMap<>();
        for (User user : usersList) {
            users.computeIfAbsent(user.age, key -> new ArrayList<>()).add(user);
        }
        return users;
    }
}
