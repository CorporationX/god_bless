package faang.school.godbless.BJS2_18413;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String job;
    private String address;

    private static Set<String> VALID_JOBS = Set.of("Uber", "Google", "Amazon");
    private static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static Integer ADULT_AGE = 18;

    public User(String name, Integer age, String job, String address) {
        if (name == null || name.equals(""))
            throw new IllegalArgumentException("Name shouldn't be null or empty");
        if (age < ADULT_AGE)
            throw new IllegalArgumentException("Age should be greater than 18");
        if (!VALID_JOBS.contains(job))
            throw new IllegalArgumentException("Job should be from Job list");
        if (!VALID_ADDRESSES.contains(address))
            throw new IllegalArgumentException("Address should be from Address list");

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

}
