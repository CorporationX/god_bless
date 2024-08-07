package faang.school.godbless.grouping_users_by_age;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("John", 20, "Google", "London"),
                new User("Jane", 20, "Uber", "Amsterdam"),
                new User("Bob", 30, "Amazon", "New York"),
                new User("Alice", 30, "Google", "Amsterdam"),
                new User("Mike", 17, "Microsoft", "Chicago")
        );

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            List<User> usersByAge = entry.getValue();
            for (User user : usersByAge) {
                System.out.println(user);
            }
        }
    }
}