package school.faang.userregistration;

import lombok.NonNull;

public class User {

    private static final int MIN_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(@NonNull String name, int age, @NonNull String job, @NonNull String address) {
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

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
