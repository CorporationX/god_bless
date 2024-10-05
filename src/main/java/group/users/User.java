package group.users;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    private static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static int minAge = 18;

    private String name;
    private int age;
    private String company;
    private String address;

    public User(String name, int age, String company, String address) {
        validateValues(name, age, company, address);
        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsersByAge(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            groupedUsers.putIfAbsent(user.getAge(), new ArrayList<>());
            groupedUsers.get(user.getAge()).add(user);
        }
        return groupedUsers;
    }

    private static void validateValues(String name, int age, String company, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name value: " + name + ". The name value must not be empty");
        } else if (age < minAge) {
            throw new IllegalArgumentException("Invalid age value: " + age + ". The age value must be equal or greater than 18");
        } else if (!VALID_JOBS.contains(company)) {
            throw new IllegalArgumentException("Invalid company value: " + company);
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address value: " + address);
        }
    }
}
