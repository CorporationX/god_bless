package faang.school.godbless.Task5;

import java.util.Collections;
import java.util.Set;

public class User {

    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set VALID_JOBS = Collections.unmodifiableSet(Set.of
            ("Google","Uber","Amazon"));
    private static final Set VALID_ADDRESSES = Collections.unmodifiableSet(Set.of
            ("London", "New York", "Amsterdam"));

    public User(String name, int age, String job, String address) {
        if (name.isBlank() || age < 18 || !VALID_ADDRESSES.contains(address) ||
                !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
    }

    public static void main(String[] args) {

        User user1 = new User("Andrew", 26, "Uber", "Amsterdam");
        User user2 = new User("John", 17, "Uber", "Amsterdam");

    }

}
