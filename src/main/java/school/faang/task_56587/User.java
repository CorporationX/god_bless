package school.faang.task_56587;

import lombok.NonNull;
import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int CORRECT_WORD = 18;

    public User(@NonNull String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name is empty!");
        }
        if (age < CORRECT_WORD) {
            throw new IllegalArgumentException("Age less than 18");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Incorrect address");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Incorrect job");
        }
        this.name = name;
        this.age = age;
        this.address = address;
        this.job = job;
    }
}
