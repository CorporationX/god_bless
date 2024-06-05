package faang.school.godbless.JavaBeisic.BJS2_7839;

import lombok.Data;

import java.util.*;

public class Task {
    public static void main(String[] args) {
        try {
        User user = new User("Lexa", 18, "Google", "London");
        User user1 = new User("Dima", 18, "Yandex", "Moscow");
        User user2 = new User("Katya", 17, "Uber", "New York");
        User user3 = new User("Bobic", 21, "Amazon", "Amsterdam");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
@Data
class User{
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String workplace;
    private String address;
    public User(String name, int age, String workplace, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The name cannot be empty.");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18.");
        }
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("The place of work must be one of the following:" + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address must be one of the following:" + VALID_ADDRESSES);
        }
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }
        public static Map<Integer, List<User>> groupUsers (List < User > users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            int ageUsers = user.getAge();
            groupedUsers.putIfAbsent(ageUsers, new ArrayList<>());
            groupedUsers.get(ageUsers).add(user);
        }
        return groupedUsers;

    }
}
