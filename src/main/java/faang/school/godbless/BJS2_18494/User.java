package faang.school.godbless.BJS2_18494;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public String getName() {
        return name;
    }


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            if (userGroups.containsKey(user.age)) {
                userGroups.get(user.age).add(user);
            } else {
                userGroups.put(user.age, new ArrayList<User>());
                userGroups.get(user.age).add(user);
            }
        }
        return userGroups;
    }
}
