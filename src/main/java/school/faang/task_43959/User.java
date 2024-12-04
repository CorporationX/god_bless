package school.faang.task_43959;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

        Map<Integer, List<User>> grouped = new HashMap<>();

        for (User user : users) {
            grouped.computeIfAbsent(user.getAge(), age -> new ArrayList<>()).add(user);
        }
        return grouped;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{name = " + name + "}";
    }
}
