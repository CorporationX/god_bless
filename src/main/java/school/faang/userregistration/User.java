package school.faang.userregistration;

import lombok.Getter;
import java.util.Set;

public class User {
    @Getter
    private String name;
    private Integer age;
    private String job;
    private String address;

    @Getter
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    @Getter
    private static final Set<String> VALID_ADDRESSES  = Set.of("London", "New York", "Amsterdam");

    public User(String name, Integer age, String job, String address) {
        validateName(name);
        validateAge(age);
        validateJob(job);
        validateAddress(address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateName(String name) {
        if (name == "" || name == null) {
            throw new IllegalArgumentException("Name is not valid!");
        }
    }

    private void validateAge(Integer age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age is not valid!");
        }
    }

    private void validateJob(String validJob) {
        if (!getVALID_JOBS().contains(validJob)) {
            throw new IllegalArgumentException("Job is not valid!");
        }
    }

    private void validateAddress(String validAddress) {
        if (!getVALID_ADDRESSES().contains(validAddress)) {
            throw new IllegalArgumentException("Address is not valid!");
        }
    }


}
