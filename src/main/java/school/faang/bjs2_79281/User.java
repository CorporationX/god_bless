package school.faang.bjs2_79281;

import java.util.List;
import java.util.Objects;

public class User {
    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");
    private static final int VALID_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        StringBuilder exceptionMessage = createExceptionMassage(name, age, job, address);
        if (exceptionMessage.isEmpty()) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        } else {
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }

    private StringBuilder createExceptionMassage(String name, int age, String job, String address) {
        StringBuilder exceptionMassage = new StringBuilder();

        if (Objects.isNull(name)) {
            exceptionMassage.append("Name is null\n");
        } else if (name.isBlank()) {
            exceptionMassage.append("Name is empty\n");
        }
        if (age < VALID_AGE) {
            exceptionMassage.append(String.format("Age under 18, your age is %s\n", age));
        }
        if (!VALID_JOBS.contains(job)) {
            exceptionMassage.append(String.format("Illegal job, your job is %s\n", job));
        }
        if (!VALID_ADDRESSES.contains(address)) {
            exceptionMassage.append(String.format("Illegal address your address is %s", address));
        }

        return exceptionMassage;
    }
}