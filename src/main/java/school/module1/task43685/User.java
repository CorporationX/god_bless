package school.module1.task43685;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {

        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }

        if (age < 18) {
            throw new IllegalArgumentException("age under 18");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(" job location is not contained in the set");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("address is not contained in the set");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;

    }
}
