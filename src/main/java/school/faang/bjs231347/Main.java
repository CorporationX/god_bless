package school.faang.bjs231347;

import school.faang.bjs231347.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", 30, "Developer", "123 Main St"));
        users.add(new User("Bob", 25, "Designer", "456 Maple Ave"));
        users.add(new User("Charlie", 28, "Manager", "789 Oak Dr"));
        users.add(new User("Diana", 32, "Analyst", "101 Pine Ln"));
        users.add(new User("Eve", 27, "Tester", "202 Birch Rd"));
        users.add(new User("Carl", 25, "Manager", "123 Maple Ave"));

        Map<Integer, List<User>> resultMap = User.groupUsers(users);
        System.out.println(resultMap);
    }
}
