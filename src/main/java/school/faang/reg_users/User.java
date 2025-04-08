package school.faang.reg_users;

import lombok.ToString;
import java.util.Set;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }

        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        } else {
            this.age = age;
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job");
        } else {
            this.job = job;
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        } else {
            this.address = address;
        }
    }


}
