package school.faang.user.registration;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final int minAge = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, Byte age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        if (age < minAge) {
            throw new IllegalArgumentException("Age < 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Not valid job");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Not valid address");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
