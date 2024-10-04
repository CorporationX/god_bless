package groupUsers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();

        users.forEach(user -> {
            userGroups.putIfAbsent(user.getAge(), new ArrayList<>());
            userGroups.get(user.getAge()).add(user);
        });

        return userGroups;
    }
}
