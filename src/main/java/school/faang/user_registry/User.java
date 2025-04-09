package school.faang.user_registry;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@ToString
@Getter
public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int VALID_AGE = 18;

    public User(String name, int age, String job, String address) throws IllegalArgumentException {
        validateArguments(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateArguments(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Пустое имя пользователя");
        }
        if (age < VALID_AGE) {
            throw new IllegalArgumentException(String.format("Возраст пользователя меньше %d", VALID_AGE));
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Недопустимое место работы: " + job);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Недопустимое место жительства: " + address);
        }
    }
}
