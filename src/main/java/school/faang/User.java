package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

@Getter
@ToString
@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        users.forEach(user -> {
            userGroups.computeIfAbsent(user.age, usersGroupList -> new ArrayList<>());
            userGroups.get(user.age).add(user);
        });
        return userGroups;
    }
}
