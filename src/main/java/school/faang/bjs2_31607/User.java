package school.faang.bjs2_31607;

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
    private static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String company;
    private String workAddress;

    public User(String name, int age, String company, String workAddress) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Empty name");
        } else {
            this.name = name;
        }

        if (age < 18) {
            throw new IllegalArgumentException("Age under 18 is restricted");
        } else {
            this.age = age;
        }

        if (!VALID_JOBS.contains(company)) {
            throw new IllegalArgumentException("Unknown company");
        } else {
            this.company = company;
        }

        if (!VALID_ADDRESSES.contains(workAddress)) {
            throw new IllegalArgumentException("Unknown address");
        } else {
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
