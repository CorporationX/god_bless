package goupUsers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String Company;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (users == null)
            return Map.of();
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            groupUsers.computeIfAbsent(user.age, ArrayList::new).add(user);
        }
        return groupUsers;
    }
}
