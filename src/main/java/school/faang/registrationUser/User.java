package school.faang.registrationUser;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class User {
    private static final List<String> VALID_JOBS = List.of("Google", "Uber",
            "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London",
            "New York", "Amsterdam");

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            userGroups.putIfAbsent(user.getAge(), new ArrayList<>());
            userGroups.get(user.getAge()).add(user);
        }
        return userGroups;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        addUsers(users, new User("Alex", 25, "Google",
                "London"));
        addUsers(users, new User("John", 29, "Amazon",
                "Anor londo"));
        addUsers(users, new User("Vlad", 25, "Uber",
                "Amsterdam"));
        addUsers(users, new User("Katya", 49, "Facebook",
                "New York"));
        addUsers(users, new User("Michael", 29, "Google",
                "London"));
        addUsers(users, new User("Michael", 29, "Uber",
                "New York"));
        addUsers(users, new User("Michael", 17, "Uber",
                "New York"));
        addUsers(users, new User("", 17, "Uber",
                "New York"));



        Map<Integer, List<User>> userGroups = groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : userGroups.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void addUsers(List<User> users, User user) {
        try {
            if (user.getName() == null || user.getName().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
            if (user.getAge() < 18) {
                throw new IllegalArgumentException("Age cannot be less than 18");
            }
            if (!VALID_JOBS.contains(user.getWorkPlace())) {
                throw new IllegalArgumentException("Work Place is not valid");
            }
            if (!VALID_ADDRESSES.contains(user.getAddress())) {
                throw new IllegalArgumentException("Address is not valid");
            }
            users.add(user);
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to add user: " + e.getMessage());
        }
    }
}
