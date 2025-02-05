package school.faang.userregistration;

import lombok.NonNull;

import java.util.Objects;

public class User {

    private static final int MIN_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(@NonNull String name, int age, @NonNull String job, @NonNull String address) {
        Objects.requireNonNull(name, "Name cannot be null");
        Objects.requireNonNull(job, "Job cannot be null");
        Objects.requireNonNull(address, "Address cannot be null");

        checkInput(name, age, job, address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void checkInput(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя пользователя не задано");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст пользователя не может быть меньше 18 лет");
        }
        if (!ValidJob.isValid(job)) {
            throw new IllegalArgumentException("Недопустимое место работы: " + job);
        }
        if (!ValidAddresses.isValid(address)) {
            throw new IllegalArgumentException("Недопустимый адрес: " + address);
        }
    }
}
