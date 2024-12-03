package school.faang.sprint_1.task_43702;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.util.List;

@EqualsAndHashCode
public class User {
    public static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    public static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    private String name;
    private Integer age;
    private String job;
    private String address;

    public User(@NonNull String name, @NonNull Integer age, @NonNull String job, @NonNull String address) {
        validateFields(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateFields(String name, Integer age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name can`t be null");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age must be greater or equal 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job " + job + " isn`t valid");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Job " + job + " isn`t valid");
        }
    }
}
