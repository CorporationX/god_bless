package school.faang.BJS2_85629;

import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> ageBrackets = new HashMap<>();
        if (users == null || users.isEmpty()) {
            return ageBrackets;
        }
        for (User user : users) {
            List<User> peers = new ArrayList<>();
            ageBrackets.putIfAbsent(user.age, peers);
            ageBrackets.get(user.age).add(user);
        }
        return ageBrackets;
    }
}
