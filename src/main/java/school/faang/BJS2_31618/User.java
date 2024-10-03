package school.faang.BJS2_31618;

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
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int VALID_AGE = 18;

    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        validateName(name);
        validateAge(age);
        validateWorkplace(workplace);
        validateAddress(address);

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (users == null) {
            throw new IllegalArgumentException("Given users list was null");
        }

        Map<Integer, List<User>> ageUsersPairs = new HashMap<>();
        for (User user : users) {
            ageUsersPairs.computeIfAbsent(user.getAge(), age -> new ArrayList<>()).add(user);
        }
        return ageUsersPairs;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name.");
        }
    }

    private void validateAge(int age) {
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Invalid age. Must be at least 18 years old.");
        }
    }

    private void validateWorkplace(String workplace) {
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Invalid workplace.");
        }
    }

    private void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address.");
        }
    }
}
