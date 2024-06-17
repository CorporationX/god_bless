package faang.school.godbless.registratuon_users;

import lombok.*;

import java.util.*;


@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private final int VALID_MIN_AGE = 18;
    private final int VALID_MAX_AGE = 65;
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        checkValidParam(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        if (users != null) {
            users.stream().forEach(user -> groupUsers.computeIfAbsent(user.getAge(), e -> new ArrayList<>()).add(user));
        }
        return groupUsers;
    }

    private void checkValidParam(String name, int age, String job, String address) {
        if (name == null || job == null || address == null) {
            throw new NullPointerException("Parameter shouldn't be null!");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name shouldn't be empty!");
        }
        if (age < VALID_MIN_AGE || age > VALID_MAX_AGE) {
            throw new IllegalArgumentException(String.format("Age shouldn't be more %s and less %s!", VALID_MIN_AGE, VALID_MAX_AGE));
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Not valid job!");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Not valid address!");
        }
    }
}
