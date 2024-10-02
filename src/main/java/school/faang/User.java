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
    private String userName;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user : users) {
            map.computeIfAbsent(user.getAge(), age -> new ArrayList<>()).add(user);
        }

        return map;
    }
}
