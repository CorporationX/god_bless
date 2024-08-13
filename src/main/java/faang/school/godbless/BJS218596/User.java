package faang.school.godbless.BJS218596;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final String name;
    private final int age;
    private final String placeWork;
    private final String address;

    public User(String name, Integer age, String placeWork, String address) {
        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public String toString() {
        return String.format("[Name: %s, Age: %d, place work: %s, address: %s]", name, age, placeWork, address);
    }

    public static Map<Integer, ArrayList<User>> groupUsers(List<User> users) {
        Map<Integer, ArrayList<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            if (user != null){
                int age = user.getAge();
                groupUsers.computeIfAbsent(age, k -> new ArrayList<>()).add(user);
            }
        }
        return groupUsers;
    }
}

