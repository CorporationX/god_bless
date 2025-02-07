package school.faang.groupUsers;

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
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user : users) {
            int key = user.age;
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>(List.of(user)));
            } else {
                map.get(key).add(user);
            }
        }
        return map;
    }

}