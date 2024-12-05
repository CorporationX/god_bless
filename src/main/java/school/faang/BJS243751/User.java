package school.faang.BJS243751;


import lombok.Data;
import java.util.Set;

@Data
public class User {

    private String name;
    private int age;
    private String job;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of(
            "Google",
            "Uber",
            "Amazon"
    );

    public static final Set<String> VALID_ADDRESSES  = Set.of(
            "London",
            "New York",
            "Amsterdam"
    );

    public User(String name, int age, String job, String address) {
        validateName(name);
        validateAge(age);
        validateJob(job);
        validateAddress(address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty!");
        }
    }

    private void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("The age must be over 18!");
        }
    }

    private void validateJob(String job) {
        if (job == null || !isPropertyExists(job, VALID_JOBS)) {
            throw new IllegalArgumentException("Invalid job!");
        }
    }

    private void validateAddress(String address) {
        if (address == null || !isPropertyExists(address, VALID_ADDRESSES)) {
            throw new IllegalArgumentException("Invalid address!");
        }
    }

    private boolean isPropertyExists(String value, Set<String> list) {
        return list.contains(value);
    }
}
