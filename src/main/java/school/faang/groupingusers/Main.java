package school.faang.groupingusers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Natalya", 25, "Office", "g.Minsk");
        User user2 = new User("Petr", 25, "Office", "g.Moscow");
        User user3 = new User("Alex", 35, "Office", "London");

        List<User> users = Arrays.asList(user1, user2, user3);

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("  " + user);
            }
        }
    }
}
