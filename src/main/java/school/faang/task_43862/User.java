package school.faang.task_43862;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@ToString
public class User {
    private static final int MAX_AGE = 100;
    private String name;
    @Getter
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
        Map<Integer, List<User>> usersByGroup = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            if (age > MAX_AGE) {
                System.out.println("Incorrect age: " + user);
            }

            if (!usersByGroup.containsKey(age)) {
                usersByGroup.put(age, new ArrayList<>());
            }
            usersByGroup.get(age).add(user);
        }
        return usersByGroup;
    }
}
