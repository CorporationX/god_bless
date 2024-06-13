package faang.school.godbless.javaCore.registerUser;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else if (age < 18) {
            throw new IllegalArgumentException("Возраст должен быть больше 18 лет");
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы не подходит");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес не подходит");
        }
        this.job = job;
        this.name = name;
        this.age = age;
        this.address = address;
    }
}