package school.faang.groupingUserByAge;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Eva", 20, "Company A", "Address 1"),
                new User("David", 25, "Company B", "Address 2"),
                new User("Alex", 38, "Company C", "Address 3"),
                new User("Nick", 20, "Company D", "Address 4")
        );

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.printf("Age group: %d%n", entry.getKey());
            System.out.println("------");

            for (User user : entry.getValue()) {
                System.out.printf("Name: %-10s | Company:%-15s | Address: %-20s%n", user.getName(),
                        user.getWorkplace(), user.getAddress());
            }
        }

        System.out.println();
    }
}
