package school.faang.JavaBasic.BJS2_31659;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(List.of(
                new User("Alice", 27, "Google", "London"),
                new User("Bob", 34, "Amazon", "London"),
                new User("Charlie", 25, "Amazon", "New York"),
                new User("Diana", 30, "Uber", "Amsterdam"),
                new User("Edward", 40, "Google", "New York"),
                new User("Fiona", 22, "Uber", "Amsterdam"),
                new User("George", 22, "Google", "Amsterdam"),
                new User("Hannah", 31, "Uber", "Amsterdam"),
                new User("Ian", 27, "Uber", "Amsterdam")
        ));
        Map<Integer, List<User>> groupedUsersByAge = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : groupedUsersByAge.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            List<User> usersByAge = entry.getValue();
            for (User user : usersByAge) {
                System.out.println(user);
            }
        }
    }
}
