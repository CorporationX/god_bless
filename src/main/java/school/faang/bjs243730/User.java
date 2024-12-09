package school.faang.bjs243730;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
public class User {

    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    @Getter
    private String name;
    private Integer age;
    private String job;
    private String address;

    public User(String name, Integer age, String job, String address) {
        this.name = validateName(name);
        this.age = validateAge(age);
        this.job = validateJob(job);
        this.address = validateAddress(address);
    }

    private String validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name should not be empty or null");
        }
        return name;
    }

    private Integer validateAge(Integer age) {
        if (age == null || age < 18) {
            throw new IllegalArgumentException("Age should not be null and must be at least 18");
        }
        return age;
    }

    private String validateJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The workplace must be contained in the set of VALID_JOBS");
        }
        return job;
    }

    private String validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address must be contained in the set of VALID_ADDRESSES");
        }
        return address;
    }

}
