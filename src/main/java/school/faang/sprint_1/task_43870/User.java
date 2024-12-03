package school.faang.sprint_1.task_43870;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
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
        Map<Integer, List<User>> ageGrouping = new HashMap<>();
        for (User user : users) {
            ageGrouping.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return ageGrouping;
    }

    @Override
    public String toString() {
        return "name: " + name
                + ", age: " + age
                + ", workplace: "
                + workplace
                + ", address: " + address;
    }
}