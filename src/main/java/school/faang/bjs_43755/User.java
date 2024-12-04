package school.faang.bjs_43755;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }

        if (age <= 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно быть содержится в наборе VALID_JOBS.");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен быть содержится в наборе VALID_ADDRESSES.");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
