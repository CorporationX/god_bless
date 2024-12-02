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
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
        validateInputFields(this);
    }

    private void validateInputFields(User user) {
        List<String> errorMessages = new ArrayList<>();
        boolean isInvalid = Boolean.FALSE;
        if (user.getName() == null || user.getName().isEmpty() || user.getName().isBlank()) {
            errorMessages.add("name is empty");
            isInvalid = Boolean.TRUE;
        }
        if (user.getAge() < MINIMUM_AGE) {
            errorMessages.add("age cannot be less than 18");
            isInvalid = Boolean.TRUE;
        }
        if (!VALID_JOBS.contains(user.getJob())) {
            errorMessages.add("invalid job");
            isInvalid = Boolean.TRUE;
        }
        if (!VALID_ADDRESSES.contains(user.getAddress())) {
            errorMessages.add("invalid address");
            isInvalid = Boolean.TRUE;
        }
        if (isInvalid) {
            String messages = errorMessages.stream().collect(Collectors.joining(", ", "errors: ", "."));
            throw new IllegalArgumentException(messages);
        }

    }
}
