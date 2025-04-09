package gratsio_BJS2_68181;
import java.util.Set;

public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");
    public static final int MIN_AGE = 18;
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid user name!An empty line has been entered.");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Invalid age! The entered age is less than 18.");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job!Incorrect place of work has been entered.");
        }
        if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Invalid address!Incorrect address is entered.");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
