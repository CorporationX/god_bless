package school.faang.task56538;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final Integer age;
    private final String job;
    private final String address;

    public User(String name, Integer age, String job, String address) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя не должно быть пустым.");
        }
        if (age != null && age >= 18) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        }
        if (job != null && VALID_JOBS.contains(job)) {
            this.job = job;
        } else {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS.");
        }
        if (address != null && VALID_ADDRESSES.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES.");
        }
    }
}
