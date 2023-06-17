package faang.school.godbless.user_registration;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    private static final int BORDERLINE_AGE = 18;

    private static Map<Integer, List<User>> userAgeMap = new HashMap<>();

    public User(String name, int age, String job, String address) {
        validateName(name);
        validateAge(age);
        validateJob(job);
        validateAddress(address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        userAgeMap = new HashMap<>();
        for (User user : users) {
            List<User> userList = userAgeMap.getOrDefault(user.age, new ArrayList<>());
            userList.add(user);
            userAgeMap.put(user.age, userList);
        }
        return userAgeMap;
    }

    public static void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Incorrect name!");
        }
    }

    public static void validateAge(int age) {
        if (age < BORDERLINE_AGE) {
            throw new IllegalArgumentException("Incorrect age!");
        }
    }

    public static void validateJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Incorrect job!");
        }
    }

    public static void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Incorrect address!");
        }
    }
}
