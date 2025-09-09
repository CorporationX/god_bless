package school.faang.bjs2_85597;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    private static final int MIN_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым, введите имя.");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст не может быть ниже " + MIN_AGE + " лет.");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы не входит в пул разрешенных.");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес не входит в пул разрешенных.");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}