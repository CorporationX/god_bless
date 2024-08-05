package faang.school.godbless.beksultan2005;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", 25, "Company A", "Address 1"));
        users.add(new User("Bob", 30, "Company B", "Address 2"));
        users.add(new User("Charlie", 25, "Company C", "Address 3"));
        users.add(new User("David", 30, "Company D", "Address 4"));
        users.add(new User("Eve", 35, "Company E", "Address 5"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        groupedUsers.forEach((age, userList) -> {
            userList.forEach(user -> System.out.println("  " + user));
        });
    }
}
