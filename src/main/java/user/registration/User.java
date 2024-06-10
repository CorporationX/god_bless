package user.registration;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of("Uber", "Amazon", "Google");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "Amsterdam", "New York");

    public User(String name, int age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;

        if (name.isBlank()) {
            throw new IllegalArgumentException("The Name field cannot be empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Invalid work place");
        }

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public String getAddress() {
        return address;
    }

    static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> usersAge = new HashMap<>();

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            int age = user.age;
            if (!usersAge.containsKey(age)) {
                usersAge.put(age, new ArrayList<>());
            }
            usersAge.get(age).add(user);
        }
        return usersAge;
    }
}