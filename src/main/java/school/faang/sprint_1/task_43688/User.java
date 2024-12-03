package school.faang.sprint_1.task_43688;

import java.util.Arrays;

public class User {
    private static final String[] VALID_JOBS = {"Google", "Uber", "Amazon"};
    private static final String[] VALID_ADDRESSES = {"London", "New York", "Amsterdam"};

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty");
        } else {
            this.name = name;
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        } else {
            this.age = age;
        }
        if (!Arrays.asList(VALID_JOBS).contains(job)) {
            throw new IllegalArgumentException("Place of work must contain: " + Arrays.toString(VALID_JOBS));
        } else {
            this.job = job;
        }
        if (!Arrays.asList(VALID_ADDRESSES).contains(address)) {
            throw new IllegalArgumentException("Work address must contain: " + Arrays.toString(VALID_ADDRESSES));
        } else {
            this.address = address;
        }
    }

    @Override
    public String toString() {
        return "User name: '" + name + '\''
                + ", age: " + age
                + ", job: '" + job + '\''
                + ", address: '" + address + '\'';
    }
}