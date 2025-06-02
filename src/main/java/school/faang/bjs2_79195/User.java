package school.faang.bjs2_79195;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final int VALID_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York");

    public User(String name, int age, String job, String address) {
        validUser(name, age, job, address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private boolean isValidName(String name) {
        return name != null && !name.isBlank();
    }

    private boolean isValidAge(int age) {
        return age >= VALID_AGE;
    }

    private boolean isValidJob(String job) {
        return VALID_JOBS.contains(job);
    }

    private boolean isValidAddress(String address) {
        return VALID_ADDRESSES.contains(address);
    }

    private void validUser(String name, int age, String job, String address) throws IllegalArgumentException {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Name cannot be empty or blank");
        } else if (!isValidAge(age)) {
            throw new IllegalArgumentException("Age cannot be at least " + VALID_AGE);
        } else if (!isValidJob(job)) {
            throw new IllegalArgumentException("Job must be one of the valid job: " + VALID_JOBS);
        } else if (!isValidAddress(address)) {
            throw new IllegalArgumentException("Address must be one of the valid addresses: " + VALID_ADDRESSES);
        }
    }

}
