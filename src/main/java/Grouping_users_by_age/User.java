package Grouping_users_by_age;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersMap = new HashMap<>();

        for (User user : users) {
            if (!usersMap.containsKey(user.age)) {
                usersMap.put(user.age, new ArrayList<>());
            }
            usersMap.get(user.age).add(user);
        }
        return usersMap;
    }
}
