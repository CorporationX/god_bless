package bjs2_2121;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        check(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void check(String name, int age, String job, String address) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("name cannot be empty");
        if (age < 18)
            throw new IllegalArgumentException("age cannot be less than 18");
        if (job == null || !VALID_JOBS.contains(job))
            throw new IllegalArgumentException("job not found");
        if (address == null || !VALID_ADDRESSES.contains(address))
            throw new IllegalArgumentException("address not found");
    }
}
