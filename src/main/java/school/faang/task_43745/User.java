package school.faang.task_43745;


import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));
    private static final int AGE_BORDER = 18;
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) throws IllegalAccessException {

        if (name.trim().isEmpty()) {
            throw new IllegalAccessException("Data validation error, check that the name is filled in");
        }
        if (age < AGE_BORDER) {
            throw new IllegalAccessException("Data validation error, check that age at least 18;");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalAccessException("Data validation error, check "
                    + "that the place of work from the list: \"Google\", \"Uber\", \"Amazon\";");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalAccessException("Data validation error, check "
                    + "that the address from the list: \"London\", \"New York\", \"Amsterdam\".");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
