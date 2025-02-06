package UserGrouping;

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
    public static final Map<Integer, List<User>> USERS = new HashMap<>();

    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        for (User user : userList) {
            USERS.computeIfAbsent(user.getAge(),
                    value -> new ArrayList<>()).add(user);
        }
        return USERS;
    }
}
