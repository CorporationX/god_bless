package school.faang.task56383;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;
    private static final Set VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name.isEmpty() || name == null) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
        this.name = name;

        if (age < 18 || name == null) {
            throw new IllegalArgumentException("Вам меньше 18 лет.");
        }
        this.age = age;

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Указанная работа не соответствует критерию.");
        }
        this.job = job;

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Указанный адрес не соответствует критерию.");
        }
        this.address = address;
    }
}