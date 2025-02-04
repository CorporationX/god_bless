package school.faang.BJS2_56336;

import lombok.NonNull;

import java.util.Set;


public class User {
    public static final Set<String> VALID_JOBS = Set.of(
            "Google",
            "Uber",
            "Amazon"
    );
    public static final Set<String> VALID_ADDRESSES = Set.of(
            "London",
            "New York",
            "Amsterdam"
    );
    public static final int MIN_LEGAL_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    @NonNull
    public User(String name, int age, String job, String address) {
        valid();
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void valid() {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
        if (age < MIN_LEGAL_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS.");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES.");
        }
    }
}