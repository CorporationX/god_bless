package school.faang.BJS2_85708;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class User {
    public static final List<String> VALID_JOBS = Arrays.asList("Google", "Uber", "Amazon");
    public static final List<String> VALID_ADDRESSES = Arrays.asList("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS.");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES.");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}