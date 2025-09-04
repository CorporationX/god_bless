package school.faang.bjs2_85565;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private static final int MIN_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше " + MIN_AGE + ".");
        }
        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы недопустимо.");
        }
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес недопустимый.");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
