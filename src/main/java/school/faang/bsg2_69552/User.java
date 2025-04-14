package school.faang.bsg2_69552;

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

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> ageGroups = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();


            ageGroups.computeIfAbsent(age, k -> new ArrayList<>()).add(user);
        }

        return ageGroups;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age +
                ", workplace='" + workplace + "', address='" + address + "'}";
    }
}