package faang.school.godbless.user;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public record User(String name, Integer age, String workPlace, String address) {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");

    public User {
        validate(name, age, workPlace, address);
    }

    private void validate(String name, Integer age, String workPlace, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty or null");
        }
        if (age == null || age < 18) {
            throw new IllegalArgumentException("Age cannot be null or less than 18");
        }
        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Invalid work place");
        }
        if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::age));
    }
}

