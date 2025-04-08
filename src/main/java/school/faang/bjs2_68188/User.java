package school.faang.bjs2_68188;

import lombok.Data;
import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int VALID_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) throws IllegalArgumentException {
        if (checkString(name) || age < VALID_AGE || !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Constructor parameters are not correct. Check the fields.");
        } else {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
    }

    private boolean checkString(String str) {
        return  str == null || str.isBlank();
    }
}
