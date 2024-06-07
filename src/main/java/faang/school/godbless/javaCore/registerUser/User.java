package faang.school.godbless.javaCore.registerUser;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        /*
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException();
        } else if (age < 18) {
            throw new IllegalArgumentException();
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException();
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }
        */
        if (name == null || name.isBlank() || name.isEmpty()
                || age < 18
                || !VALID_JOBS.contains(job)
                || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }
        this.job = job;
        this.name = name;
        this.age = age;
        this.address = address;
    }
}