package faang.school.godbless.Hashmap.UserRegistration;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));

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

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }

    private void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age should be older than 18");
        }
    }

    private void validateWorkplace(String workplace) {
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Invalid workplace");
        }
    }

    private void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            if (!groupedUsers.containsKey(age)) {
                groupedUsers.put(age, new ArrayList<>());
            }
            groupedUsers.get(age).add(user);
        }
        return groupedUsers;
    }
}

