package school.faang.basic.grouping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record User(String name, Integer age, String workspace, String address) {

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        var result = new HashMap<Integer, List<User>>();
        users.forEach(user -> result.computeIfAbsent(user.age, (age) -> new ArrayList<>()).add(user));
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}