package faang.school.godbless.alexbulgakoff.userregistration;

import lombok.ToString;

import java.util.Set;

/**
 * @author Alexander Bulgakov
 */

@ToString
public class User {

    private String name;

    private Integer age;

    private String jobName;

    private String address;

    private final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");

    private final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, Integer age, String jobName, String address) {
        if (name == null || age < 18
                || !VALID_JOBS.contains(jobName)
                || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        } else {

            this.name = name;
            this.age = age;
            this.jobName = jobName;
            this.address = address;
        }
    }

}
