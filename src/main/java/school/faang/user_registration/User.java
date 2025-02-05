package school.faang.user_registration;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(@NonNull String name, int age, @NonNull String job, @NonNull String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Переданный возраст %d меньше допустимого %d".formatted(age, MIN_AGE));
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно быть в " + VALID_JOBS);
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Вы должны проживать в " + VALID_ADDRESSES);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
