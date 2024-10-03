package school.faang.users;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String company;
    private String address;

    public User(String name, int age, String company, String address) {
        validateName(name);
        validateAge(age);
        validateCompany(company);
        validateAddress(address);

        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroupsByAge = new HashMap<>();
        users.forEach(user -> userGroupsByAge
                .computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user));
        return userGroupsByAge;
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name.");
        }
    }

    private void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Invalid age.");
        }
    }

    private void validateCompany(String company) {
        if (!VALID_JOBS.contains(company)) {
            throw new IllegalArgumentException("Invalid company.");
        }
    }

    private void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address.");
        }
    }
}
