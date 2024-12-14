package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        checkValidityName(name);
        checkValidityAge(age);
        checkWorkplaceInSet(workplace);
        checkAddressInSet(address);

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> ageGroups = new HashMap<>();

        for (User user : users) {
            if (ageGroups.containsKey(user.age)) {
                ageGroups.get(user.age).add(user);
            } else {
                ageGroups.put(user.age, new ArrayList<User>());
                ageGroups.get(user.age).add(user);
            }
        }
        return ageGroups;
    }

    private void checkValidityName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void checkValidityAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("The age cannot be less than 18");
        }
    }

    private void checkWorkplaceInSet(String workplace) {
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Workplace is not on the set");
        }
    }

    private void checkAddressInSet(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is not on the set");
        }
    }
}
