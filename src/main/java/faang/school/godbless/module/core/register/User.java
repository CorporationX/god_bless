package faang.school.godbless.module.core.register;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@EqualsAndHashCode
@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int PERMITTED_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        validateUserFields(name, age, job, address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private static void validateUserFields(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("имя не может быть пустым");
        }
        if (age < PERMITTED_AGE) {
            throw new IllegalArgumentException("возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(String.format("место работы должно содержаться во множестве %s", String.join(",", VALID_JOBS)));
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(String.format("место работы должно содержаться во множестве %s", String.join(",", VALID_ADDRESSES)));
        }
    }
}
