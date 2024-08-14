package faang.school.godbless.userregistration;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String workCompanyName;
    private String homeAddress;

    public User(String name, int age, String workCompanyName, String homeAddress) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        if (!VALID_JOBS.contains(workCompanyName)) {
            throw new IllegalArgumentException("Work Company Name must be one of: " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(homeAddress)) {
            throw new IllegalArgumentException("Home Address must be one of: " + VALID_ADDRESSES);
        }

        this.name = name;
        this.age = age;
        this.workCompanyName = workCompanyName;
        this.homeAddress = homeAddress;
    }

    public static Set<String> getValidJobs() {
        return VALID_JOBS;
    }

    public static Set<String> getValidAddresses() {
        return VALID_ADDRESSES;
    }
}
