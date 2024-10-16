package school.faang.m1s1.bjs2_31607;

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
    private static final int MIN_AGE = 18;
    private static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String company;
    private String workAddress;

    public User(String name, int age, String company, String workAddress) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Empty name");
        } else if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age under 18 is restricted");
        } else if (!VALID_JOBS.contains(company)) {
            throw new IllegalArgumentException("Unknown company");
        } else if (!VALID_ADDRESSES.contains(workAddress)) {
            throw new IllegalArgumentException("Unknown address");
        } else {
            this.name = name;
            this.age = age;
            this.company = company;
            this.workAddress = workAddress;
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> ageGroups = new HashMap<>();

        for (User user : userList) {
            ageGroups.computeIfAbsent(user.getAge(), key -> new ArrayList<>()).add(user);
        }

        return ageGroups;
    }
}
