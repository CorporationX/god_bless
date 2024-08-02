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

    public User(String name, Integer age, String job, String address) {
        if (name == null || name.equals("") || age < 18 || !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(address))
            throw new IllegalArgumentException();

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

}
