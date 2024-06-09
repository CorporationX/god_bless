package faang.school.godbless.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.*;

@Data
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int REQUIRED_AGE = 18;

    private String name;
    private Integer age;
    private String company;
    private String address;


    public User(String name, Integer age, String company, String address) {
        validateName(name, "The name can not be empty");
        validateAge(age, "The age must be " + REQUIRED_AGE + " age over");
        validateJob(company, "Invalid job");
        validateAddress(address, "Invalid address");


        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }


    private void validateName(String value, String message) {

        if (value.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validateAge(Integer value, String message) {
        if (value < REQUIRED_AGE) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validateJob(String value, String message) {
        if (!VALID_JOBS.contains(value)) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validateAddress(String value, String message) {
        if (!VALID_ADDRESSES.contains(value)) {
            throw new IllegalArgumentException(message);
        }
    }


}
