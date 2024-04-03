package faang.school.godbless.bjs2_4211;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@ToString
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int AGE_LIMIT = 18;

    private String name;
    private int age;
    private String jobPlace;
    private String address;

    public User(String name, int age, String jobPlace, String address) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        } else if (age < AGE_LIMIT) {
            throw new IllegalArgumentException("Age can't be less than " + AGE_LIMIT);
        } else if (!VALID_JOBS.contains(jobPlace)) {
            throw new IllegalArgumentException(jobPlace + " no correct. Jobs should be in valid company: " + String.join(", ", VALID_JOBS));
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(address + " not correct. Address should be in valid cities: " + String.join(", ", VALID_ADDRESSES));
        }
        this.name = name;
        this.age = age;
        this.jobPlace = jobPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupMapUsers = new HashMap<>();

        for (User user : users) {
            groupMapUsers.computeIfAbsent(user.age, key -> new ArrayList<>()).add(user);
        }
        return groupMapUsers;
    }

    public void setName(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < AGE_LIMIT) {
            throw new IllegalArgumentException("Age can't be less than " + AGE_LIMIT);
        }
        this.age = age;
    }

    public void setJobPlace(String jobPlace) {
        if (!VALID_JOBS.contains(jobPlace)) {
            throw new IllegalArgumentException(jobPlace + " no correct. Jobs should be in valid company: " + String.join(", ", VALID_JOBS));
        }
        this.jobPlace = jobPlace;
    }

    public void setAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(address + " not correct. Address should be in valid cities: " + String.join(", ", VALID_ADDRESSES));
        }
        this.address = address;
    }
}
