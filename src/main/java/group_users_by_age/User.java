package group_users_by_age;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int MINIMUM_AGE = 18;

    public User(String name, int age, String placeOfWork, String address) {
        validateName(name);
        validateAge(age);
        validatePlaceOfWork();
        validateAddress();

        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    private void validateAddress() {
        if (!VALID_ADDRESSES.contains(this.address)) {
            throw new IllegalArgumentException("Invalid address");
        }
    }

    private void validatePlaceOfWork() {
        if (!VALID_JOBS.contains(this.placeOfWork)) {
            throw new IllegalArgumentException("Invalid place of work");
        }
    }

    private static void validateAge(int age) {
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Age should be equal or greater than 18");
        }
    }

    private static void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedMapByAge = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            groupedMapByAge.computeIfAbsent(age, k -> new ArrayList<>()).add(user);
        }
        return groupedMapByAge;
    }
}
