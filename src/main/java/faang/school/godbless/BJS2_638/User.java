package faang.school.godbless.BJS2_638;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
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
        Map<Integer, List<User>> userMap = new HashMap<>();
        for (User user : users) {
            userMap.putIfAbsent(user.age, new ArrayList<>());
            userMap.get(user.age).add(user);
        }
        return userMap;

    }

    public static void main(String[] args) {
    }
}
