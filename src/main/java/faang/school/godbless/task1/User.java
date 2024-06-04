package faang.school.godbless.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

record User(String name, int age, String workplace, String address) {
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groups = new HashMap<>();
        for (User user : users) {
            if (!groups.containsKey(user.age())) {
                groups.put(user.age(), new ArrayList<>());
                groups.get(user.age()).add(user);
            } else {
                groups.get(user.age()).add(user);
            }
        }
        return groups;
    }
}
