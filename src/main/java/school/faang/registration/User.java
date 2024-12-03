package school.faang.registration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name.isBlank() || age < 18 || !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Wrong parameters!");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
