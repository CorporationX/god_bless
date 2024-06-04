package faang.school.godbless;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Set;

@Data
public class User {

    private String name;
    private Integer age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = new HashSet<>(List.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(List.of("London", "New York", "Amsterdam"));

    public User(String name, Integer age, String job, String address) {
        if (!this.validate(name, age, job, address)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private boolean validate(String name, Integer age, String job, String address) {
        if (name== null || name.isEmpty()) {
            return false;
        }
        if (age< 18) {
            return false;
        }
        if (!VALID_ADDRESSES.contains(address)) {
            return false;
        }
        if (!VALID_JOBS.contains(job)) {
            return false;
        }
        return true;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}
