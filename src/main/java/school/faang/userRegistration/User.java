package school.faang.userRegistration;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    @NotNull
    private final String name;
    @Min(18)
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name.isEmpty())
            throw new IllegalArgumentException("The name is empty!");
        this.name = name;
        if (age < 18)
            throw new IllegalArgumentException("The age is under 18!");
        this.age = age;
        if (!VALID_JOBS.contains(job))
            throw new IllegalArgumentException("The job is not valid!");
        this.job = job;
        if (!VALID_ADDRESSES.contains(address))
            throw new IllegalArgumentException("The address is not valid!");
        this.address = address;
    }
}
