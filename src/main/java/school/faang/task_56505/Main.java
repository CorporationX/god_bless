package school.faang.task_56505;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alice", 30, "Company A", "123 Street A"),
                new User("Bob", 25, "Company B", "456 Street B"),
                new User("Charlie", 30, "Company C", "789 Street C"),
                new User("David", 25, "Company D", "101 Street D"),
                new User("Eve", 35, "Company E", "202 Street E")
        );
        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user);
            }
            System.out.println();
        }
    }
}
