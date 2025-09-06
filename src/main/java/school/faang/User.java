package school.faang;

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

    public static Map<Integer, List<User>> groupUsers(List<User> listOfUsers) {
        Map<Integer, List<User>> groupOfUsersByAge = new HashMap<>();

        for (User user : listOfUsers) {
            if (!groupOfUsersByAge.containsKey(user.age)) {
                groupOfUsersByAge.put(user.age, new ArrayList<>());
            }
            groupOfUsersByAge.get(user.age).add(user);
        }

        return groupOfUsersByAge;

    }

    @Override
    public String toString() {
        return String.format("Name: %s | Age: %d | Workplace: %s | Address: %s",
                name, age, workplace, address);
    }
}
