package school.faang.task_56446;

import java.util.Objects;
import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int VALID_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы не валидное, его нет в коллекции VALID_JOBS");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес не валидный, его нет в коллекции VALID_ADDRESSES ");
        }

        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.age = Objects.requireNonNull(age, "Age cannot be null");
        this.job = Objects.requireNonNull(job, "Job cannot be null");
        this.address = Objects.requireNonNull(address, "Address cannot be null");
    }
}
