package school.faang.Bjs2_85628;

import java.util.Set;

public class User {
    private static final int MINIMUM_AGE = 18;
    private static final Set<String> VALID_JOB = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESS = Set.of("Лондон", "Нью-Йорк", "Амстердам");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        validateName(name);
        validateAge(age);
        validateJob(job);
        validateAddress(address);
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Empty name");
        }
        this.name = name;
    }

    private void validateAge(int age) {
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Age less of " + MINIMUM_AGE);
        }
        this.age = age;
    }

    private void validateJob(String job) {
        if (job == null || !VALID_JOB.contains(job)) {
            throw new IllegalArgumentException("Job incorrect");
        }
        this.job = job;
    }

    private void validateAddress(String address) {
        if (address == null || !VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Address incorrect");
        }
        this.address = address;
    }
}