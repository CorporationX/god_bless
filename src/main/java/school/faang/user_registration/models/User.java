package school.faang.user_registration.models;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@ToString
@Getter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static final int AGE_LIMIT = 18;
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        validateName(name);
        validateAge(age);
        validateJob(job);
        validateAddress(address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
    }

    private void validateAge(int age) {
        if (age < AGE_LIMIT) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
    }

    private void validateJob(String job) {
        if (isNotValidValue(job, VALID_JOBS)) {
            throw new IllegalArgumentException("Недопустимое место работы. Допустимые варианты: " + VALID_JOBS);
        }
    }

    private void validateAddress(String address) {
        if (isNotValidValue(address, VALID_ADDRESSES)) {
            throw new IllegalArgumentException("Недопустимый адрес. Допустимые варианты: " + VALID_ADDRESSES);
        }
    }

    private boolean isNotValidValue(String value, Set<String> validValues) {
        return !validValues.contains(value);
    }
}
