package school.faang.model;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private String job;
    private String address;
    private int age;

    public User(String name, String job, String address, int age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
        if (!(VALID_JOBS.contains(job))) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS.");
        }
        if (!(VALID_ADDRESSES.contains(address))) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES.");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        }

        this.name = name;
        this.job = job;
        this.address = address;
        this.age = age;
    }
}
