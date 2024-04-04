package faang.school.godbless.groupUsers;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {

    private static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));
    private static final int MINIMAL_USER_AGE = 18;

    private String name;
    private int age;
    private String work;
    private String address;

    public User(String name, int age, String work, String address) {
        validateParameters(name, age, work, address);

        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }

    private void validateParameters(String name, int age, String workplace, String address) {
        if (name == null || name.isEmpty() || age < MINIMAL_USER_AGE
                || !VALID_JOBS.contains(workplace) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid user parameters");
        }
    }
}
