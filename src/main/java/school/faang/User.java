package school.faang;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Amazon", "Microsoft", "Apple", "Facebook");

    private static final Set<String> VALID_ADDRESSES = Set.of("New York", "Seattle", "San Francisco", "Los Angeles", "Chicago");


    public User(String name, int age, String job, String address) {
        validateName(name);
        validateAge(age);
        validateWorkplace(job);
        validateAddress(address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The name cannot be empty.");
        }
    }

    private void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("The age must not be less than 18.");
        }
    }

    private void validateWorkplace(String workplace) {
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Unacceptable place of work: " + workplace);
        }
    }

    private void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address: " + address);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}