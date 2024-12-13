package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        User user1 = new User("Alice", 25, "Google", "London");
        User user2 = new User("Bob", 25, "Amazon", "Seattle, USA");
        User user3 = new User("Charlie", 30, "Microsoft", "Redmond, USA");
        User user4 = new User("Diana", 30, "Meta", "Menlo Park, USA");
        User user5 = new User("Eve", 40, "Apple", "Cupertino, USA");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        Map<Integer, List<User>> usersGroup = User.groupUsers(users);
        System.out.println(usersGroup);
    }
}
