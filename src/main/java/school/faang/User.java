package school.faang;

import lombok.Data;

import java.util.Set;


@Data
public class User {
    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    static final int VALID_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (!name.isEmpty() & age >= VALID_AGE & VALID_JOBS.contains(job) &
                VALID_ADDRESSES.contains(address)) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        } else {
            throw new IllegalArgumentException("Invalid argument");
        }


    }
}
