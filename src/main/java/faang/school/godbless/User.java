package faang.school.godbless;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    private static final int MIN_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private Integer age;
    private String jobPlace;
    private String address;

    public User(String name, int age, String job, String address) {
        this.setName(name);
        this.setAge(age);
        this.setJob(job);
        this.setAddress(address);
    }

    public void setJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job value: " + job);
        }

        this.jobPlace = job;
    }

    public void setAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address value: " + address);
        }

        this.address = address;
    }

    public void setAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("The age must be more 18");
        }

        this.age = age;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("The name must not be empty");
        }

        this.name = name;
    }

    public static Map<Integer, List<User>> groupUsersByAge(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();

        for(User user: users) {
            result.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return result;
    }
}
