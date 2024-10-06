package school.faang.BJS2_31758;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> activities;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESS = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(int id, String name, int age, Set<String> activities, String job, String address) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18.");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job. Job must be one of " + VALID_JOBS);
        }

        if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Invalid address. Addres must be one of " + VALID_ADDRESS);
        }

        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
        this.job = job;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Set<String> getActivities() {
        return activities;
    }

    public String getJob() {
        return job;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", job='" + job + '\'' +
            ", address='" + address + '\'' +
            '}';
    }
}
