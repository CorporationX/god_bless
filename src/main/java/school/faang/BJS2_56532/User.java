package school.faang.BJS2_56532;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private static final int MIN_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (!validateName(name)) {
            throw new IllegalArgumentException("Invalid user name");
        } else if (!validateAge(age)) {
            throw new IllegalArgumentException("Age must not be less than 18");
        } else if (!validateJob(job)) {
            throw new IllegalArgumentException("Invalid job");
        } else if (!validateAddress(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private boolean validateName(String name) {
        return name != null && !name.isBlank();
    }

    private boolean validateAge(int age) {
        return age >= MIN_AGE;
    }

    private boolean validateJob(String job) {
        return job != null && VALID_JOBS.contains(job);
    }

    private boolean validateAddress(String address) {
        return address != null && VALID_ADDRESSES.contains(address);
    }
}
