package school.faang.registration_user;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private final String name;
    private final Integer age;
    private final String job;
    private final String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    public User(String name, Integer age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("[X] Имя не может быть пустым.");
        }
        if (age == null) {
            throw new IllegalArgumentException("[X] Возраст не может быть null.");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("[X] Возраст не должен быть меньше " + MIN_AGE + ".");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(
                    String.format("[X] Недопустимая работа: '%s'. Допустимые значения: %s",
                    job, VALID_JOBS));
        }
        if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException(
                    String.format("[X] Недопустимый адрес: '%s'. Допустимые значения: %s",
                    address, VALID_ADDRESS));
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
