package school.faang.sprint1.task43740reguser;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public class User {
    private final String name;
    private final Integer age;
    private final String job;
    private final String address;

    public final List<String> validJobs = Arrays.asList("Google", "Uber", "Amazon");
    public final List<String> validAddresses = Arrays.asList("London", "New York", "Amsterdam");


    public User(String name, Integer age, String job, String address) {
        if (name == null || age < 18 || !validJobs.contains(job) || !validAddresses.contains(address)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}

