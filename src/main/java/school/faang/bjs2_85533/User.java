package school.faang.bjs2_85533;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class User {
    private static final int AGE_OF_MAJORITY = 18;
    private static final List<String> VALID_JOB = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) throws IllegalArgumentException {
        if (name.isBlank()) {
            throw new IllegalArgumentException("name is null");
        }

        if (age < AGE_OF_MAJORITY) {
            throw new IllegalArgumentException("age under 18");
        }
        if (!VALID_JOB.contains(job)) {
            throw new IllegalArgumentException(job + ": there is no such work");
        } else {
            this.job = job;

        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(address + ": no such address");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
