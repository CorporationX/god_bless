package userregistration;

import lombok.Data;

import javax.xml.validation.Validator;
import java.util.Set;

@Data
public class User {

    private String name;
    private Integer age;
    private String jobPlace;
    private String address;
    private final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, Integer age, String jobPlace, String address) throws Exception {
        if (name.isEmpty()) {
            throw new Exception("Name must be filled!");
        }
        if (age < 18) {
            throw new Exception("Age must be over 18 years!");
        }
        if (!VALID_JOBS.contains(jobPlace)) {
            throw new Exception("Job place must be valid!");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new Exception("Address must be valid!");
        }

        this.name = name;
        this.age = age;
        this.jobPlace = jobPlace;
        this.address = address;

    }
}
