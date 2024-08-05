package faang.school.godbless.BJS2_18407;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String placeWork;
    private String address;

    public User(String name, int age, String placeWork, String address) {
        if (name.isBlank() || age < 18 || !VALID_JOBS.contains(placeWork) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid arguments.");
        }

        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> ageGroups = new HashMap<>();

        for (User user : users) {
            List<User> count = ageGroups.getOrDefault(user.age, new ArrayList<>());
            count.add(user);
            ageGroups.put(user.age, count);
        }

        return ageGroups;
    }
}
