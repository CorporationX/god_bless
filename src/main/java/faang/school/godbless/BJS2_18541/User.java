package faang.school.godbless.BJS2_18541;

import lombok.Getter;
import lombok.Setter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class User {

    private String name;
    private int age;
    private String workPlace;
    private String address;

    private final int MINIMUM_AGE = 18;

    private final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(String name, int age, String workPlace, String address) {
        if (name == null){
            throw new IllegalArgumentException("Name is null");
        }
        else if (name.isBlank()) {
            throw new IllegalArgumentException("Name is empty");
        }
        else if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("The age is too small");
        }
        else if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("The job didn't find");
        }
        else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address didn't find");
        }
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }
}
