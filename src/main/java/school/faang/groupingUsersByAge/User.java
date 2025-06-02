package school.faang.groupingUsersByAge;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data

public class User {
    private String name;
    private int age;
    private String addressWork;
    private String address;

    public User(String name, int age, String addressWork, String address) {
        this.name = name;
        this.age = age;
        this.addressWork = addressWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();

        for (User user : users) {
            result.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return result;
    }
}