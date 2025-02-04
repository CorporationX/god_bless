package school.faang.user_registration;

import java.util.Set;

public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым или null");
        }

        if (age < MIN_AGE) {
            throw new IllegalArgumentException(String.format("Возраст должен быть больше %s", MIN_AGE));
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно быть в " + VALID_JOBS);
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Вы должны проживать в " + VALID_ADDRESSES);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;


    }
}