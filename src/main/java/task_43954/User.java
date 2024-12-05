package task_43954;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    @Getter
    private int age;
    private String workPlace;
    private String address;

    public User(int age) {
        this.age = age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> usersByAge = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();

            usersByAge.putIfAbsent(age, new ArrayList<>());
            usersByAge.get(age).add(user);

        }

        return usersByAge;
    }
}
