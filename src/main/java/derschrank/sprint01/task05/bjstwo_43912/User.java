package derschrank.sprint01.task05.bjstwo_43912;

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
    private String work;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> list) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user : list) {
            if (map.get(user.age) == null) {
                map.put(user.age, new ArrayList<User>());
            }
            map.get(user.age).add(user);
        }
        return map;
    }

    @Override
    public String toString() {
        return String.format("%s (%d), works at %s, lives at %s", name, age, work, address);
    }
}
