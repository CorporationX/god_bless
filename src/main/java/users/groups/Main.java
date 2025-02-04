package users.groups;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Lily", 25, "Google", "New York"),
                new User("Tom", 30, "Facebook", "San Francisco"),
                new User("Harry", 25, "Amazon", "Seattle"),
                new User("David", 30, "Apple", "Los Angeles"),
                new User("John", 35, "Microsoft", "Portland")
        );

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
