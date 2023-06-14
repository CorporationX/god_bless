package faang.school.godbless;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class User {
    private final static Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String userName, int age, String job, String userAddress) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        } else {
            this.name = userName;
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be less 0");
        } else {
            this.age = age;
        }
        if (!(VALID_JOBS.contains(job))) {
            throw new IllegalArgumentException("Invalid job");
        } else {
            this.job = job;
        }
        if (!(VALID_ADDRESSES.contains(address))) {
            throw new IllegalArgumentException("Invalid address");
        } else {
            this.address = userAddress;
        }

    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }

}