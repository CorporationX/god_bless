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

    private final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(String name, int age, String workPlace, String address) {
        if (name.isEmpty() || age < 18 || !VALID_JOBS.contains(workPlace) || !VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }
}
