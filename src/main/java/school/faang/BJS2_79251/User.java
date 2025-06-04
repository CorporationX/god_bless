package school.faang.BJS2_79251;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESS = new HashSet<>(Set.of("London", "New-York", "Amsterdam"));

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name can not to be null or empty");
        }

        if (age < 18) {
            throw new IllegalArgumentException("the user must be of legal age");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("place of employment is not suitable");
        }

        if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("residential address is not on the list of available addresses");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
