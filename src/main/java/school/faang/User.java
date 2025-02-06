package school.faang;

import java.util.Set;

public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public static final Set<String> VALID_JOBS;
    public static final Set<String> VALID_ADDRESSES;
    public static final int MIN_AGE = 18;

    static {
        VALID_JOBS = Set.of("Google", "Uber", "Amazon");
        VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    }

    public User(String name, int age, String job, String address) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age cannot be less than " + MIN_AGE + "! Age " + age);
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank!");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job! Job " + job + " is not valid!");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address! Address " + address + " is not valid!");
        }

        this.age = age;
        this.job = job;
        this.address = address;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getAddress() {
        return address;
    }


}

