package school.faang.agegrouping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", 25, "Company A", "Address 1"));
        users.add(new User("Bob", 30, "Company B", "Address 2"));
        users.add(new User("Charlie", 25, "Company A", "Address 3"));
        users.add(new User("David", 30, "Company B", "Address 4"));
        users.add(new User("Eve", 35, "Company C", "Address 5"));
        HashMap<Integer, List<User>> groupedUsers = User.groupingByAge(users);

        groupedUsers.forEach((age, userList) -> {
            System.out.println("Age: " + age);
            for (User user : userList) {
                System.out.println("  " + user);
            }
        });
    }
}
