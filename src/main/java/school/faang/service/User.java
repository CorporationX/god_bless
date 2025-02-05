package school.faang.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public User(String name, int age, String placeWork, String address) {
        this.name = name;
        this.age = age;
        this.workplace = placeWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        for (User user : users)
            usersByAge.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        return usersByAge;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }
}

