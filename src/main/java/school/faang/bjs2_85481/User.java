package school.faang.bjs2_85481;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String name; // имя пользователя.
    private int age; // возраст пользователя.
    private String job; // место работы.
    private String address; // адрес.

    private static final int VALID_AGE = 18;
    private static final Set<String> VALID_JOBS =
            new HashSet<String>(Set.of(new String[]{"Google", "Uber", "Amazon"}));
    private static final Set<String> VALID_ADDRESSES =
            new HashSet<String>(Set.of(new String[]{"London", "New York", "Amsterdam"}));

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("User age cannot be less than " + VALID_AGE);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The job description should include: \"Google\", \"Uber\", \"Amazon\"");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address description should include: " +
                    "\"London\", \"New York\", \"Amsterdam\"");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
