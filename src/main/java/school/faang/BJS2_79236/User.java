package school.faang.BJS2_79236;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User:\n" +
                "  Name: " + name + "\n" +
                "  Age: " + age + "\n" +
                "  Workplace: " + workplace + "\n" +
                "  Address: " + address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> grouped = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            grouped.computeIfAbsent(age, k -> new ArrayList<>()).add(user);
        }
        return grouped;
    }
}
