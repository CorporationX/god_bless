package school.faang.bjs268455;
import lombok.Builder;
import java.util.Set;

@Builder
public class Employee {
    private String name;
    private Integer age;
    private String job;
    private String address;
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public Employee(String name, Integer age, String job, String address) {
        // add validation for VALID_JOBS and VALID_ADDRESSES

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        if (age == null || age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older.");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Inadmissible place of work: " + job);
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Inadmissible address: " + address);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}