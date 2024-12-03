package school.faang.task_43691;

import java.util.Set;
import java.util.function.Predicate;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final int MIN_AGE = 18; // reason: no magic numbers
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        this.name = validate(name, value -> !value.isEmpty(), "name");
        this.age = validate(age, value -> value >= MIN_AGE, "age");
        this.job = validate(job, VALID_JOBS::contains, "job");
        this.address = validate(address, VALID_ADDRESSES::contains, "address");
    }

    private static <T> T validate(T field, Predicate<T> predicate, String fieldName) {
        if (!predicate.test(field)) {
            throw new IllegalArgumentException(fieldName + " is not valid");
        }
        return field;
    }
}
