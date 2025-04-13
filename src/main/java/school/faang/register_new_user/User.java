package school.faang.register_new_user;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int MINIMAL_AGE= 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым!");
        }

        if (age < MINIMAL_AGE) {
            throw new IllegalArgumentException("Несовершеннолетним вход воспрещен!");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Неверное место работы!");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Неверный регион!");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}