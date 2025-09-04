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

    public User(String name, Integer age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("[X] Имя не может быть пустым.");
        }
        if (age == null) {
            throw new IllegalArgumentException("[X] Возраст не может быть null.");
        }
        if (age < 18) {
            throw new IllegalArgumentException("[X] Возраст не должен быть меньше 18.");
        }
        if (job == null) {
            throw new IllegalArgumentException("[X] Работа не может быть null.");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(
                    String.format("[X] Недопустимая работа: '%s'. Допустимые значения: %s",
                    job, VALID_JOBS));
        }
        if (address == null) {
            throw new IllegalArgumentException("[X] Адрес не может быть null.");
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
