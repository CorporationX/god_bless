package school.faang.bjs2_85698;

import lombok.AllArgsConstructor;

import java.util.Set;


public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Invalid age");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
