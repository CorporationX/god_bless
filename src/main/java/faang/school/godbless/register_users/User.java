package faang.school.godbless.register_users;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Predicate;

public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Apple");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        validate(name, p -> !p.isEmpty() || !p.isBlank(), "Name cannot be empty.");
        validate(age, a -> a >= 18, "Age cannot be less than 18.");
        validate(job, VALID_JOBS::contains,
                "Job can only be a member of the set: " + Arrays.toString(VALID_JOBS.toArray()));
        validate(address, VALID_ADDRESSES::contains,
                "Address can only be a member of the set: " + Arrays.toString(VALID_ADDRESSES.toArray()));

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private <T> void validate(T param, Predicate<T> predicate, String message) {
        if (!predicate.test(param)) {
            throw new IllegalArgumentException(message);
        }
    }
}
