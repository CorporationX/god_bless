package school.faang.bjs2_85490;

import java.util.Arrays;
import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {

        validateParams(name, age, job, address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateParams(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше " + MIN_AGE);
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе: "
                + VALID_JOBS);
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе: "
                + VALID_ADDRESSES);
        }
    }
}
