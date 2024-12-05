package school.faang.task_43933;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record User(String name, int age, String workplace, String address) {

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user : users) {
            map.computeIfAbsent(user.age, key -> new ArrayList<>()).add(user);
        }

        return map;
    }
}
