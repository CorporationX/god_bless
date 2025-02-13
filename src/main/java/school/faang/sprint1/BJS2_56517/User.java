package school.faang.sprint1.BJS2_56517;

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

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    @NonNull
    public User(String name, int age, String job, String address) {
        validName(name);
        validAge(age);
        validJob(job);
        validAddres(address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }


    private void validName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым." + name);
        }
    }

    private void validAge(int age) {
        if (age < MIN_LEGAL_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18." + age);
        }
    }

    private void validJob(String  job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS." + job);
        }
    }

    private void validAddres(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES." + address);
        }
    }
}