package faang.school.godbless.sprint2.task1;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age cannot be less than " + MIN_AGE + ".");
        }
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Invalid job.");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address.");
        }

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            if (!groupedUsers.containsKey(user.age)) {
                groupedUsers.put(user.age, new ArrayList<>());
            }
            groupedUsers.get(user.age).add(user);
        }
        return groupedUsers;
    }
}
