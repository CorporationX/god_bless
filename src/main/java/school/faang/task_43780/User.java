package school.faang.task_43780;

import lombok.ToString;

import java.util.*;

@ToString
public class User {

    private static final int AGE_THRESHOLD = 18;
    private static final List<String> VALID_JOBS = Arrays.asList("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = Arrays.asList("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        validate(name, age, workPlace, address);
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    private void validate(String name, int age, String workPlace, String address) {
        Optional.ofNullable(name)
                .orElseThrow(() -> new IllegalArgumentException("Name can't be null"));
        Optional.ofNullable(age > AGE_THRESHOLD ? age : null)
                .orElseThrow(() -> new IllegalArgumentException("Age can't be lees than %d".formatted(AGE_THRESHOLD)));
        Optional.ofNullable(VALID_JOBS.contains(workPlace) ? workPlace : null)
                .orElseThrow(() -> new IllegalArgumentException("Work Place can't exist"));
        Optional.ofNullable(VALID_ADDRESSES.contains(address) ? address : null)
                .orElseThrow(() -> new IllegalArgumentException("Address can't exist"));
    }
}
