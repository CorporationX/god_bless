package faang.school.godbless;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        try {
            List<User> users = List.of(
            new User("Ivan", 28, "Google", "London"),
            new User("Sidor", 48, "Facebook", "Moscow"),
            new User("Petr", 64, "Amazon", "Amsterdam"),
            new User("Anna", 42, "EPAM", "Samara"),
            new User("Vera", 31, "Microsoft", "New York"),
            new User("Ira", 20, "Uber", "London"));

            Map<Integer, List<User>> groupUsers = User.groupUsers(users);

            for (Map.Entry<Integer, List<User>> entry : groupUsers.entrySet()) {
                System.out.println("age " + entry.getKey());
                for (User user : entry.getValue()) {
                    System.out.println("  " + user);
                }
            }
        }
        catch (IllegalArgumentException e) {
           System.out.println("Error: " + e.getMessage());
       }
    }
}