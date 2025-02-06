package school.faang.BJS2_56352;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alice", 25, "Google", "New York"),
                new User("Bob", 30, "Amazon", "San Francisco"),
                new User("Charlie", 25, "Microsoft", "Seattle"),
                new User("David", 28, "Facebook", "Los Angeles"),
                new User("Eva", 30, "Apple", "Chicago"),
                new User("Frank", 35, "Tesla", "Austin"),
                new User("Grace", 40, "IBM", "Boston"),
                new User("Hannah", 25, "Netflix", "Denver"),
                new User("Isaac", 28, "Adobe", "San Diego"),
                new User("Jack", 35, "SpaceX", "Miami")
        );

        Map<Integer, List<User>> ageToUsersMap  = User.groupUsers(users);

        System.out.println("=== Grouped Users by Age ===");
        ageToUsersMap.forEach((age, userList) -> {
            System.out.printf("Age: %d%n", age);
            System.out.println("----------------------------");
            for (User user : userList) {
                System.out.printf("  Name: %-10s | Work: %-12s | Address: %-15s%n",
                        user.getName(), user.getWorkPlace(), user.getAddress());
            }
            System.out.println();
        });
    }
}
