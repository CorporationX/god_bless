package school.faang;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int VALID_AGE = 18;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым или не заданным");
        }
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Возраст пользователя не может быть меньше" + VALID_AGE);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе: " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе: " + VALID_ADDRESSES);
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}