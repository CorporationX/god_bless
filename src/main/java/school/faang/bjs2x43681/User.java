package school.faang.bjs2x43681;

import java.util.List;
import java.util.Set;
import lombok.Getter;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name == "") {
            throw new IllegalArgumentException("Name value mustn't be empty");
        } else {
            this.name = name;
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age mustn't be less 18");
        } else {
            this.age = age;
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid place of job");
        } else {
            this.job = job;
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        } else {
            this.address = address;
        }
    }

    public static void main(String[] args) {
        try {
            List<User> users = List.of(
                    new User("Peter", 27, "Google", "New York"),
                    new User("Gomer", 45, "Uber", "Amsterdam"),
                    new User("Mohamed", 33, "Amazon", "London"),
                    new User("Jack", 32, "Amazon", "Amsterdam"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
