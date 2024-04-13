package faang.school.godbless.registration;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {

    private String name;

    private int age;

    private String job;

    private String address;

    private static final Set<String> VALID_JOBS = new HashSet<>();

    static {
        VALID_JOBS.add("Google");
        VALID_JOBS.add("Uber");
        VALID_JOBS.add("Amazon");
    }

    private static final Set<String> VALID_ADDRESSES = new HashSet<>();

    static {
        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New-York");
        VALID_ADDRESSES.add("Amsterdam");
    }

    public User(String name, int age, String job, String address) {
        if (VALID_ADDRESSES.contains(address) && VALID_JOBS.contains(job) && age >= 18 && !name.isEmpty()) {
            this.address = address;
            this.job = job;
            this.age = age;
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid information. Check User details");
        }
    }
}
