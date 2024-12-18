package school.faang.task_43780;

import lombok.ToString;

import java.util.*;

@ToString
public class User {

    private final int AGE_THRESHOLD = 18;
    private static final List<String> VALID_JOBS = Arrays.asList("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = Arrays.asList("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        this.name = Optional.ofNullable(name).orElseThrow(IllegalArgumentException::new);
        this.age = Optional.ofNullable(age > AGE_THRESHOLD ? age : null).orElseThrow(IllegalArgumentException::new);
        this.workPlace = Optional.ofNullable(VALID_JOBS.contains(workPlace) ? workPlace : null)
                .orElseThrow(IllegalArgumentException::new);
        this.address = Optional.ofNullable(VALID_ADDRESSES.contains(address) ? address : null)
                .orElseThrow(IllegalArgumentException::new);
    }
}
