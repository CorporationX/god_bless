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
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String userName, int age, String job, String userAddress) {
        if (userName!=null && !userName.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be less 0");
        }
        if (!(VALID_JOBS.contains(job))) {
            throw new IllegalArgumentException("Invalid job");
        }
        if (!(VALID_ADDRESSES.contains(userAddress))) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.name = userName;
        this.age = age;
        this.job = job;
        this.address = userAddress;

    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }

}