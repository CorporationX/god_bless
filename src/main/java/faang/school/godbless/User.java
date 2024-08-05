package faang.school.godbless;
import lombok.Getter;

import java.util.*;

public class User {
    private String name;
    @Getter
    private int age;
    private String workplace;
    private String address;

    // Constructor
    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }


    // Method groupUsers
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
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    // Main method test
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", 25, "Company A", "123 Main St"));
        users.add(new User("Bob", 30, "Company B", "456 Elm St"));
        users.add(new User("Charlie", 25, "Company C", "789 Oak St"));
        users.add(new User("David", 30, "Company D", "101 Pine St"));
        users.add(new User("Eve", 35, "Company E", "202 Maple St"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("    " + user);
            }
        }
    }
}