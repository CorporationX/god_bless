package faang.school.godbless.task1_2;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class User {
    private static final int VALID_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        validUserData(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(User::getAge));
    }

    private void validUserData(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name could not be blank");
        }
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Age could not be less than 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job name is incorrect");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is incorrect");
        }
    }
}
