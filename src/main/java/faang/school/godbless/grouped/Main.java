package faang.school.godbless.grouped;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("John", 30, "Moscow", "123 Main St"));
        users.add(new User("Alice", 25, "Saint-Petersburg", "456 Elm St"));
        users.add(new User("Bob", 30, "Saint-Petersburg", "789 Oak St"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            int age = entry.getKey();
            List<User> userList = entry.getValue();
            System.out.println("Age: " + age);
            for (User user : userList) {
                System.out.println("  " + user.getName());
            }
        }
    }
}
