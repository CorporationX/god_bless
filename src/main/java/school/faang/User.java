package school.faang;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int VALID_AGE = 18;
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        checkName(name);
        checkAge(age);
        checkJob(job);
        checkAddress(address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void checkName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Illegal name - user's name can't be null or blank.");
        }
    }

    private void checkAge(int age) {
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Illegal age - user can't be a minor.");
        }
    }

    private void checkJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Illegal job - user must work in Google, Uber or Amazon");
        }
    }

    private void checkAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Illegal address - user must be in London, New York or Amsterdam");
        }
    }

    public static HashMap<Integer, List<User>> groupUsers(List<User> usersList) {
        HashMap<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : usersList) {
            groupedUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return groupedUsers;
    }
}
