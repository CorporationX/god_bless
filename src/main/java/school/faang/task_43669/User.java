package school.faang.task_43669;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MINIMUM_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        validateInputFields(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateInputFields(String name, int age, String job, String address) {
        List<String> errorMessages = new ArrayList<>();
        boolean isInvalid = false;
        if (name == null || name.isEmpty() || name.isBlank()) {
            errorMessages.add("name is empty");
            isInvalid = true;
        }
        if (age < MINIMUM_AGE) {
            errorMessages.add("age cannot be less than " + MINIMUM_AGE);
            isInvalid = true;
        }
        if (!VALID_JOBS.contains(job)) {
            errorMessages.add("invalid job");
            isInvalid = true;
        }
        if (!VALID_ADDRESSES.contains(address)) {
            errorMessages.add("invalid address");
            isInvalid = true;
        }
        if (isInvalid) {
            String messages = errorMessages.stream().collect(Collectors.joining(", ", "errors: ", "."));
            throw new IllegalArgumentException(messages);
        }

    }
}
