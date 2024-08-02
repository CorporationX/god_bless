package BJS2_18401;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;

@Data
@EqualsAndHashCode
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    private static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York"));

    public User(String name, int age, String placeOfWork, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;

        if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18.");
        }
        this.age = age;

        if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("Invalid place of work.");
        }
        this.placeOfWork = placeOfWork;

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address.");
        }
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();

        for(var user : users) {
            result.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return result;
    }
}