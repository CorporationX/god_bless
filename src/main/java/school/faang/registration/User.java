package school.faang.registration;

import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@ToString
public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    private static final Set<String> VALID_JOBS = new HashSet<>(List.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(List.of("London", "New York", "Amsterdam"));
    private static final Integer MIN_AGE = 18;

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;

        checkName();
        checkAge();
        checkJob();
        checkAddress();
    }

    private void checkName() {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
    }

    private void checkAge() {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше " + MIN_AGE);
        }
    }

    private void checkJob() {
        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в списке: " + VALID_JOBS);
        }
    }

    private void checkAddress() {
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в списке: " + VALID_ADDRESSES);
        }
    }
}