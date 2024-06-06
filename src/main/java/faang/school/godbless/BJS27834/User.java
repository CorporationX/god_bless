package faang.school.godbless.BJS27834;

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

    private String name;
    private int age;
    private String companyName;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();

        for (User user : users) {
            result.computeIfAbsent(user.getAge(), k -> new ArrayList<User>()).add(user);
        }
        return result;
    }

    public User(String name, int age, String companyName, String address) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null");
        } else if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less then 18 years");
        } else if (!VALID_JOBS.contains(companyName)) {
            throw new IllegalArgumentException("Company name must be one of the valid jobs");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address must be one of the valid addresses");
        }

        this.name = name;
        this.age = age;
        this.companyName = companyName;
        this.address = address;
    }
}
