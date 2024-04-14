package faang.school.godbless.registration;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class User {

    private String name;

    private int age;

    private String job;

    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");

    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New-York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        /*if (name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        if (age < 18) throw new IllegalArgumentException("Age cannot be less than 18");
        if (!VALID_JOBS.contains(job)) throw new IllegalArgumentException("Job is not valid: " + job);
        if (!VALID_ADDRESSES.contains(address)) throw new IllegalArgumentException("Address is not valid: " + address);
        else {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }*/
        nameValidation(name);
        ageValidation(age);
        jobValidation(job);
        addressValidation(address);
    }

    protected void nameValidation(String name) {
        if (name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        else {
            this.name = name;
        }
    }

    protected void ageValidation(int age) {
        if (age < 18) throw new IllegalArgumentException("Age cannot be less than 18");
        else {
            this.age = age;
        }
    }

    protected void jobValidation(String job) {
        if (!VALID_JOBS.contains(job)) throw new IllegalArgumentException("Job is not valid: " + job);
        else {
            this.job = job;
        }
    }

    protected void addressValidation(String address) {
        if (!VALID_ADDRESSES.contains(address)) throw new IllegalArgumentException("Address is not valid: " + address);
        else {
            this.address = address;
        }
    }
}
