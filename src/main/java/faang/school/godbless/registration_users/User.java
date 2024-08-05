package faang.school.godbless.registration_users;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@ToString
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    private final Set<String> VALID_JOBS = new HashSet<>(
            Arrays.asList("Google", "Uber", "Amazon")
    );
    private final HashSet<String> VALID_ADDRESSES = new HashSet<>(
            Arrays.asList("London", "New York", "Amsterdam")
    );

    public User(String name, int age, String placeOfWork, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }

        if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("Invalid place of work");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            groupedUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return groupedUsers;
    }
}
