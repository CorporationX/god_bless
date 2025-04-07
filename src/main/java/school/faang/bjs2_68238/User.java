package school.faang.bjs2_68238;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;
    private static final Set<String> VALID_JOBS =
            Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES =
            Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name.isBlank() || age < 18 || !VALID_JOBS
                .contains(job) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("validation exception");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
