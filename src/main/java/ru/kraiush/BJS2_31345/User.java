package ru.kraiush.BJS2_31345;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static int VALID_AGE = 18;

    private String name;
    private int age;
    private String company;
    private String address;

    public User(String name, int age, String company, String address) {
        if (name.isBlank() || age < VALID_AGE || !VALID_JOBS.contains(company) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("");
        } else {
            this.name = name;
            this.age = age;
            this.company = company;
            this.address = address;
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsersByAge = new HashMap<>();
        for (User user : users) {
            groupedUsersByAge.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return groupedUsersByAge;
    }
}
