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
        if ((!name.trim().isEmpty()) && (age >= AGE_BORDER)
                && (VALID_JOBS.contains(job) && (VALID_ADDRESSES.contains(address)))) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.job = job;
        } else {
            throw new IllegalAccessException("Data validation error, check that:\n"
                    + "1) the name is filled in;\n"
                    + "2) age at least 18;\n"
                    + "3) Place of work from the list: \"Google\", \"Uber\", \"Amazon\";\n"
                    + "4) Address from the list: \"London\", \"New York\", \"Amsterdam\".");
        }
    }


}
