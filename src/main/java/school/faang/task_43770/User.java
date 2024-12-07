package school.faang.task_43770;

import static school.faang.task_43770.ValidAddresses.VALID_ADDRESSES;
import static school.faang.task_43770.ValidJob.VALID_JOBS;

public class User {

    private static final int EIGHT_TEEN = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;

        if (this.name == null || this.name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null");
        }
        if (this.age < EIGHT_TEEN) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job should be " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address should be " + VALID_ADDRESSES);
        }
    }
}
