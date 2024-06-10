package faang.school.godbless.registratuon_users;

import lombok.*;

import java.util.*;


@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name.isBlank() || age < 18 || !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        if (users != null) {
            users.stream().forEach(user -> groupUsers.computeIfAbsent(user.getAge(), e -> new ArrayList<>()).add(user));
        }
        return groupUsers;
    }

}
