package school.faang;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String address;
    private String job;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String address, String job) {

        if (name.isEmpty()) {
            throw new IllegalStateException("name cannot be empty");
        }
        if (age < 18) {
            throw new IllegalStateException("age cannot be less than 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalStateException("job only from the list");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalStateException("city only from the list");
        }
        this.name = name;
        this.age = age;
        this.address = address;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getJob() {
        return job;
    }
}
