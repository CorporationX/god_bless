package faang.school.godbless.register_users;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Predicate;

public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Apple");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int AGE_LIMIT = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        validate(name, n -> !(n.isBlank() || n.isEmpty()), "Name cannot be empty.");
        validate(age, a -> a >= AGE_LIMIT, "Age cannot be less than 18.");
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
