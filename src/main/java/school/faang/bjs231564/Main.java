package school.faang.bjs231564;

import school.faang.bjs231347.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            List<User> users = new ArrayList<>();
            users.add(new User("Alice", 30, "Google", "London"));
            users.add(new User("Bob", 25, "Uber", "456 Maple Ave"));
            users.add(new User("Charlie", 17, "Amazon", "New York"));
            users.add(new User("", 32, "Analyst", "Amsterdam"));
            users.add(new User("Eve", 27, "Google", "New York"));
            users.add(new User("Carl", 25, "Amazon", "Amsterdam"));

            Map<Integer, List<User>> resultMap = User.groupUsers(users);
            System.out.println(resultMap);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
