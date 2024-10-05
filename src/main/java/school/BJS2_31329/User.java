package school.BJS2_31329;

import lombok.Getter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter

public class User {

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, String address, String job, int age) {
        this.name = name;
        this.address = address;
        this.job = job;
        this.age = age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            userGroups.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
        }
        return userGroups;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}