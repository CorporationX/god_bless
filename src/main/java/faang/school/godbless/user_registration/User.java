package faang.school.godbless.user_registration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    private static final int BORDERLINE_AGE = 18;

    private static Map<Integer, List<User>> userMap = new HashMap<>();

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
        userMap = new HashMap<>();
        for (User user : users) {
            if (!userMap.containsKey(user.age)) {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                userMap.put(user.age, userList);
            } else {
                userMap.get(user.age).add(user);
            }
        }
        return userMap;
    }

    public static void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateAge(int age) {
        if (age < BORDERLINE_AGE) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }
    }
}
