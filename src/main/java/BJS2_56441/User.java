package BJS2_56441;

import java.util.Set;

public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    private static final int MIN_AGE = 18;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name != null && name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        }
        if (job != null && !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS.");
        }
        if (address != null && !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES.");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
