package faang.school.godbless.registration_users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            List<User> users = new ArrayList<>(List.of(
                    new User("John", 20, "Google", "London"),
                    new User("Jane", 20, "Uber", "Amsterdam"),
                    new User("Bob", 30, "Amazon", "New York"),
                    new User("Alice", 30, "Google", "Amsterdam")
//                    new User("Mike", 17, "Microsoft", "Chicago")
            ));

            Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

            for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
                System.out.println("Age: " + entry.getKey());
                List<User> usersByAge = entry.getValue();
                for (User user : usersByAge) {
                    System.out.println(user);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}