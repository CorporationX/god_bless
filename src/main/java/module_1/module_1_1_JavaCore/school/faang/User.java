package module_1.module_1_1_JavaCore.school.faang;

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
    private static final int AGE_LIMIT = 18;

    private String userName;
    private int age;
    private String job;
    private String address;

    public User(String userName, int age, String job, String address) {
        if (userName == null || userName.trim().isEmpty())
            throw new IllegalArgumentException("User name cannot be blank");

        if (age < AGE_LIMIT) {
            throw new IllegalArgumentException("User age cannot be less than 18");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("User job is not valid");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("User address is not valid");
        }

        this.userName = userName;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user : users) {
            map.computeIfAbsent(user.getAge(), age -> new ArrayList<>()).add(user);
        }

        return map;
    }


}
