package faang.school.godbless.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public record User(String name, Integer age, String work, String address) {


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            if (!groupUsers.containsKey(user.age())) {
                groupUsers.put(user.age(), new ArrayList<>());
                groupUsers.get(user.age()).add(user);
            }
        }
        return groupUsers;
    }
}

