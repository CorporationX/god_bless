package BJS2_18476;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
public class User {

    private final int MINIMUM_AGE = 18;
    final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (validateUser(name, age, job, address)) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.job = job;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean validateUser(String name, int age, String job, String address) {
        if (name.isEmpty() || name.isBlank()) {
            System.out.println("User name should not be empty!");
            return false;
        } else if (age < MINIMUM_AGE) {
            System.out.println(name + "'s age should be more than 18!");
            return false;
        } else if (!VALID_ADDRESSES.contains(address)) {
            System.out.println(name + "'s address " + address + " not valid!");
            return false;
        } else if (!VALID_JOBS.contains(job)) {
            System.out.println(name + "'s job " + job + " not valid!");
            return false;
        }
        return true;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> resultMap = new HashMap<>();

        for (User user : users) {
            resultMap.computeIfAbsent(user.age, key -> new ArrayList<>()).add(user);
        }

        return resultMap;
    }
}