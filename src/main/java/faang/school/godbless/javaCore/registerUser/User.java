package faang.school.godbless.javaCore.registerUser;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        boolean isValid = true;
        if (name.isEmpty() || name.isBlank()) {
            isValid = false;
        } else if (age < 18) {
            isValid = false;
        } else if (!VALID_JOBS.contains(job)) {
            isValid = false;
        } else if (!VALID_ADDRESSES.contains(address)) {
            isValid = false;
        }
        if (isValid) {
            this.job = job;
            this.name = name;
            this.age = age;
            this.address = address;
        } else {
            throw new IllegalArgumentException();
        }
    }
}