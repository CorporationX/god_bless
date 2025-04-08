package school.faang.group_users;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Jake", 22, "Moscow", "Long street"),
                new User("Sam", 22, "Moscow", "Long street"),
                new User("Liam", 42, "Moscow", "Long street"),
                new User("Alex", 42, "Moscow", "Long street"),
                new User("Tom", 18, "Moscow", "Long street"),
                new User("Will", 18, "Moscow", "Long street"));

        Map<Integer, List<User>> groupedUsersByAge = User.groupUsers(users);
        System.out.println(groupedUsersByAge);
    }
}
