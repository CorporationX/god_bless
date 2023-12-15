package Grouping_users_by_age;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user : users) {
            if (!map.containsKey(user.getAge())) {
                map.put(user.getAge(), new ArrayList<>());
            }
            map.get(user.getAge()).add(user);
        }
        return map;
    }

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "\n" + "Name – " + name +
                ", Job – " + job +
                ", Address – " + address;
    }
}