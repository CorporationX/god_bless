package faang.school.godbless.user;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    private final String name;
    private final int age;
    private final String work;
    private final String address;

    public User(String name, int age, String work, String address) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name must not be empty");
        if (age < MIN_AGE) throw new IllegalArgumentException(String.format("age must be over %s", MIN_AGE));
        if (work == null || !VALID_JOBS.contains(work)) throw new IllegalArgumentException("job must be a valid value");
        if (address == null || !VALID_ADDRESSES.contains(address)) throw new IllegalArgumentException("address must be a valid value");

        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (users == null || users.isEmpty()) return Map.of();

        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }

}
