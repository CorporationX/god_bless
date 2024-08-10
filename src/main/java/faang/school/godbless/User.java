package faang.school.godbless;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor

public class User {

    public static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));

    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        if (name == null || name.isEmpty() ) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        if (placeOfWork == null || !VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("Place of work must be one of the following: " + VALID_JOBS);
        }
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address must be one of the following: " + VALID_ADDRESSES);
        }
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            if (!userGroups.containsKey(age)) {
                userGroups.put(age, new ArrayList<>());
            }
            userGroups.get(age).add(user);
        }
        return userGroups;
    }
}