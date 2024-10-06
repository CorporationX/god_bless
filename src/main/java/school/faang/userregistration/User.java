package school.faang.userregistration;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class User {

    static final Set<String> VALID_JOBS = new HashSet<>(List.of("Google", "Uber", "Amazon"));
    static final Set<String> VALID_ADDRESSES = new HashSet<>(List.of("London", "New York", "Amsterdam"));
    public static final int MIN_USER_AGE = 18;

    private String name;
    private int age;
    private String workingPlace;
    private String address;

    public User(String name, int age, String workingPlace, String address) {
        validateParameters(name, age, workingPlace, address);

        this.name = name;
        this.age = age;
        this.workingPlace = workingPlace;
        this.address = address;
    }

    private void validateParameters(String name, int age, String workingPlace, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (age < MIN_USER_AGE) {
            throw new IllegalArgumentException("Age must be at least " + MIN_USER_AGE + " but was " + age);
        }
        if (workingPlace == null || workingPlace.isEmpty() || !VALID_JOBS.contains(workingPlace)) {
            throw new IllegalArgumentException("Invalid working place - " + workingPlace);
        }
        if (address == null || address.isEmpty() || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address - " + address);
        }
    }

    public static Map<Integer, List<User>> groupUsersByAge(List<User> users) {
        if (users == null) {
            return new HashMap<>();
        }
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }
}
