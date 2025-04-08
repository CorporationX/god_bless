package school.faang.group_users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Jake", 22, "Moscow", "Long street"));
        users.add(new User("Sam", 22, "Moscow", "Long street"));
        users.add(new User("Liam", 42, "Moscow", "Long street"));
        users.add(new User("Alex", 42, "Moscow", "Long street"));
        users.add(new User("Tom", 18, "Moscow", "Long street"));
        users.add(new User("Will", 18, "Moscow", "Long street"));

        Map<Integer, List<User>> userGroups = User.groupUsers(users);
        System.out.println(userGroups);
    }
}
