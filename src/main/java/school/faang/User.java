package school.faang;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
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
        this.age = age;
        this.job = job;
        this.address = address;
        this.name = name;

        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age cannot be less than " + MIN_AGE + "! Age " + age);
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank!");
        }
        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job! Job " + job + " is not valid!");
        }
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address! Address " + address + " is not valid!");
        }

    }

    public static void main(String[] args) {
        User bob = new User("Bob", 19, "Google", "New York");
        User nate = new User("Nate", 21, "Amazon", "London");
        List<User> users = new ArrayList(List.of(bob, nate));
        System.out.println(users);
    }

    @Override
    public String toString() {
        return String.format("User: {name=%s, age='%d', job=%s, address=%s}", name, age, job, address);
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

