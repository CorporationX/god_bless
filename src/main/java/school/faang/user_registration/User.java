package school.faang.user_registration;

import lombok.Data;
import java.util.Set;

@Data
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        this.name = name;
        if (name.isEmpty() || age < 18 || !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(name + " вы не прошли валидацию");
        } else {
            this.age = age;
            this.job = job;
            this.address = address;
        }
    }
}
