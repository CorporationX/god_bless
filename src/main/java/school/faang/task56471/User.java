package school.faang.task56471;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (users == null) {
            return null;
        }
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            userGroups.putIfAbsent(user.getAge(), new ArrayList<>());
            userGroups.get(user.getAge()).add(user);
        }
        return userGroups;
    }
}
