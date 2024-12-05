package school.faang.task_43789;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static final int LEGAL_AGE = 18;
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        dataValidation(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;

    }

    private void dataValidation(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
        if (age < LEGAL_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно быть содержится в наборе VALID_JOBS.");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен быть содержится в наборе VALID_ADDRESSES.");
        }
    }
}

