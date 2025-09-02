package school.faang.BJS2_85473;

import lombok.NonNull;

import java.util.Set;

public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;
    private final int minAge = 18;

    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(@NonNull String name, @NonNull int age, @NonNull  String job, @NonNull  String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name should not be empty");
        }
        if (age < minAge) {
            throw new IllegalArgumentException("Age should be grater than " + minAge);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job is not valid");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is not valid");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
