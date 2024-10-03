package school.faang.t03;

import lombok.Getter;

import java.util.*;

public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int VALID_AGE = 18;

    private String name;
    @Getter
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        validate(name, age, workplace, address);
    }

    public void validate(String name, int age, String workplace, String address) {

        if (!name.isEmpty());
        else {
            throw new IllegalArgumentException("name is empty");
        }
        if (age >= VALID_AGE);
        else {
            throw new IllegalArgumentException("bring your parents");
        }
        if (VALID_JOBS.contains(workplace));
        {
            throw new IllegalArgumentException("invalid job");
        }
        if (VALID_ADDRESSES.contains(address));
        else {
            throw new IllegalArgumentException("invalid address");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            int key = user.getAge();
            groupedUsers.computeIfAbsent(key, k -> new ArrayList<>()).add(user);
        }
        return groupedUsers;
    }
}