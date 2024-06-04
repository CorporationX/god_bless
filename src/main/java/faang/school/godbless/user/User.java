package faang.school.godbless.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record User(String name, int age, String companyName, String address) {

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        users.forEach(user -> usersByAge.computeIfAbsent(user.age(), k -> new ArrayList<>()).add(user));
        return usersByAge;
    }
}
