package faang.school.godbless.register.user;

import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@EqualsAndHashCode
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or empty");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Age can't be less than 18");
        }

        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Work place is not valid");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is not valid");
        }

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(user -> user.age));
    }

}

