package ru.kraiush.BJS2_31345;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int VALID_AGE = 18;

    private String name;
    private int age;
    private String company;
    private String address;

    public User(String name, int age, String company, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name should not be blank");
        }
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Age should be equal or greater than 18");
        }
        if (!VALID_JOBS.contains(company)) {
            throw new IllegalArgumentException("Company should be from the list: Google, Uber or Amazon");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address should be from the list: London, New York, Amsterdam");
        }
        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsersByAge = new HashMap<>();
        for (User user : users) {
            groupedUsersByAge.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return groupedUsersByAge;
    }
}
