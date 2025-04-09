package school.faang;

import school.faang.groupusersage.User;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        testUsersGroupedByAge();
    }

    public static void testUsersGroupedByAge() {
        List<User> users = List.of(
                new User("Alice", 30, "TechCorp", "123 Main St"),
                new User("Bob", 25, "Startup Inc", "456 Oak Ave"),
                new User("Charlie", 30, "Global Ltd", "789 Pine Ln"),
                new User("David", 25, "New Firm", "111 Willow Dr")
        );

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
