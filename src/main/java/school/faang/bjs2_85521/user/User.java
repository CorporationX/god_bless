package school.faang.bjs2_85521.user;

import school.faang.bjs2_85521.exception.InvalidNameException;
import school.faang.bjs2_85521.exception.UnderageException;
import school.faang.bjs2_85521.exception.JobNotAllowedException;
import school.faang.bjs2_85521.exception.AddressNotAllowedException;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private static final int VALID_AGE = 18;

    public User(String name, int age, String job, String address) {
        validateUserData(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private static void validateUserData(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new InvalidNameException("name cannot be null, empty or a space");
        }
        if (age < VALID_AGE) {
            throw new UnderageException("age cannot be less than " + VALID_AGE);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new JobNotAllowedException("the job is not allowed for registration\n" +
                    "allowed jobs: " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new AddressNotAllowedException("the address is not allowed for registration\n" +
                    "allowed addresses: " + VALID_ADDRESSES);
        }
    }
}
