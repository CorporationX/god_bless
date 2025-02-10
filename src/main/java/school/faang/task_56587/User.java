package school.faang.task_56587;

import lombok.Data;
import lombok.NonNull;

import java.util.Set;

@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int correctAge = 18;

    public User(@NonNull String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name is empty!");
        } else if (age < correctAge) {
            throw new IllegalArgumentException("Age less than 18");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Incorrect address");
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Incorrect job");
        }
        this.name = name;
        this.age = age;
        this.address = address;
        this.job = job;

    }
}
