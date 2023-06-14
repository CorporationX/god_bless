package faang.school.godbless.age_group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private static Map<Integer, List<User>> userAgeMap = new HashMap<>();

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        for (User user : users) {
            if (!userAgeMap.containsKey(user.age)) {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                userAgeMap.put(user.age, userList);
            } else {
                userAgeMap.get(user.age).add(user);
            }
        }
        return userAgeMap;
    }

}
