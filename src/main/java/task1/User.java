package task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String work;
    private String address;

    public User(String name, int age, String work, String address) {
        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> list) {
        Map<Integer, List<User>> sortedUsersMap = new HashMap<>();
        for (User user : list) {
            if (!sortedUsersMap.containsKey(user.age)) {
                List<User> users = new ArrayList<>();
                users.add(user);
                sortedUsersMap.put(user.age, users);
                continue;
            }
            sortedUsersMap.get(user.age).add(user);
        }
        return sortedUsersMap;
    }
}