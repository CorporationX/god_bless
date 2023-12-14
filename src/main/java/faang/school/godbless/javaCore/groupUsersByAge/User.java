package faang.school.godbless.javaCore.groupUsersByAge;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
public class User {

    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESS = new HashSet<>(Arrays.asList("London", "New-York", "Amsterdam"));
    private static final int ADULT_AGE = 18;

    private String name;
    private int age;
    private String placeWork;
    private String address;


    public User(String name, int age, String placeWork, String address) {
        if (name == null && name.isBlank()) {
            throw new IllegalArgumentException("Incorrect name.");
        } else if (age < ADULT_AGE) {
            throw new IllegalArgumentException("Incorrect age.");
        } else if (placeWork == null && !VALID_JOBS.contains(placeWork)) {
            throw new IllegalArgumentException("Incorrect job.");
        } else if (address == null && !VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Incorrect address.");
        }
        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
    }
}
