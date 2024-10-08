package school.faang._12_javacore.task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserTest {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", 25, "Company A", "1234 Main St"));
        users.add(new User("Bob", 30, "Company B", "5678 Oak St"));
        users.add(new User("Charlie", 25, "Company A", "1234 Main St"));
        users.add(new User("David", 30, "Company C", "5678 Oak St"));
        users.add(new User("Eve", 35, "Company D", "91011 Elm St"));

        Map<Integer, List<User>> grouped = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : grouped.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user);
            }
        }
    }
}
