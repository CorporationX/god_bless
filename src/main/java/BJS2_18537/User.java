package BJS2_18537;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
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

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> resultMap = new HashMap<>();

        for (User user : users) {
            resultMap.computeIfAbsent(user.getAge(), x -> new ArrayList<>()).add(user);
        }

        return resultMap;
    }

    public int getAge() {
        return age;
    }
}