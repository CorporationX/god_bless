package BJS2_4323;

import lombok.ToString;

import java.util.*;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            if (!result.containsKey(user.age)) {
                result.put(user.age, new ArrayList<>());
            }
            result.get(user.age).add(user);
        }

        return result;
    }

    private void validation(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age can't be lower 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
    }

    public User(String name, int age, String job, String address) {
        validation(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}