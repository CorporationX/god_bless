package school.faang.user_registration;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import school.faang.user_registration.utility.Validator;

import java.util.Set;

@Getter
@ToString
@EqualsAndHashCode
public class User {

    private static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");

    private static Set<String> VALID_ADDRESSES = Set.of("London", "New York");

    private final String name;
    private final int age;
    private final String job;
    private final String address;



    public User(String name, int age, String job, String address) {
        if (!Validator.validateStringForNotNullAndNotEmpty(name)) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        this.name = name;

        if (age < 18) {
            throw new IllegalArgumentException("Age must be greater than 18");
        }
        this.age = age;

        if (!Validator.validateStringForNotNullAndNotEmpty(job) || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(job + " - this job not allowed!");
        }
        this.job = job;

        if (!Validator.validateStringForNotNullAndNotEmpty(address) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(address + " - this address not allowed!");
        }
        this.address = address;
    }

}

