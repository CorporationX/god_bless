package school.faang.sprint1.task_43749;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.Set;

@AllArgsConstructor

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int AGE = 18;


    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < AGE) {
            throw new IllegalArgumentException("Ты слишком мал");
        }
        this.age = age;
    }

    public void setJob(String job) {
        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Ты тут не работаешь");
        }
        this.job = job;
    }

    public void setAddress(String address) {
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Ты тут не живёшь");
        }
        this.address = address;
    }
}
