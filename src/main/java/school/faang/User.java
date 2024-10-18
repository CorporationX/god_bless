package school.faang;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final Integer MINIMAL_AGE = 18;

    private String name;
    private Integer age;
    private String workingPlace;
    private String address;

    public User(String name, Integer age, String workingPlace, String address) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The name cannot be empty.");
        }
        if (age < MINIMAL_AGE) {
            throw new IllegalArgumentException("Age cannot be less than " + MINIMAL_AGE + ".");
        }
        if (!VALID_JOBS.contains(workingPlace)) {
            throw new IllegalArgumentException("Uncorrected workingPlace");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Uncorrected address");
        }
        this.name = name;
        this.age = age;
        this.workingPlace = workingPlace;
        this.address = address;
    }


    public static Map<Integer, List<User>> groupUsers(List<User> list) {
        Map<Integer, List<User>> userMap = new HashMap<>();

        for (User user : list) {
            userMap.computeIfAbsent(user.getAge(), u -> new ArrayList<>()).add(user);
        }
        return userMap;
    }
}
