package school.faang.BJS2_58588;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private static final int MIN_AGE = 18;

    public User(String name, int age, String job, String address) {
        validateUser(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateUser(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст не должен быть младше 18 лет");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно совпадать с одним из списка: " +
                    VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен совпадать с одним из списка: " +
                    VALID_ADDRESSES);
        }
    }
}
