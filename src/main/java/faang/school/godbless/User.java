package main.java.faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> sortedUsers = new HashMap<>();
        for (User user : users) {
            if (!sortedUsers.containsKey(user.age)) {
                List<User> sameAgeUsers = new ArrayList<>();
                sameAgeUsers.add(user);
                sortedUsers.put(user.age, sameAgeUsers);
            } else {
                sortedUsers.get(user.age).add(user);
            }
        }
        return sortedUsers;
    }
}
