package school.faang.group_user_by_age;

import lombok.Data;

import java.util.*;

@Data
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int REQUIRED_AGE = 18;

    private final String name;
    private int age;
    private String company;
    private String address;

    public User(String name, int age, String company, String address) throws IllegalAccessException {
        if (name.isEmpty() || name.isBlank()) throw new IllegalAccessException("Name cannot be empty");
        if (age < REQUIRED_AGE) throw new IllegalAccessException("Age cannot be less than " + REQUIRED_AGE);
        if (!VALID_JOBS.contains(company)) throw new IllegalAccessException("Company not exists");
        if (!VALID_ADDRESSES.contains(address)) throw new IllegalAccessException("Address not exists");

        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }

    static Map<Integer, List<User>> groupUsers(List<User> users) {
        var groupedUsers = new HashMap<Integer, List<User>>();
        for (User user : users) {
            if (!groupedUsers.containsKey(user.getAge())) {
                groupedUsers.put(user.getAge(), new ArrayList<>());
            }
            groupedUsers.get(user.getAge()).add(user);
        }
        return groupedUsers;
    }
}