package school.faang.bjs2_85551;

import java.util.Set;


public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int VALID_AGE = 18;
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is null or empty");
        }
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Age must not be younger than " + VALID_AGE);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The correct place of work must be indicated.\n"
                    + job + " - your place of work\n"
                    + "List of acceptable jobs:" + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The correct address must be specified.\n"
                    + address + " - your address\n"
                    + "Correct addresses:" + VALID_ADDRESSES);
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
