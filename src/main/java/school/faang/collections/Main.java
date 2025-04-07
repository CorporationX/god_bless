package school.faang.collections;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(
                new User("Alex", 40, "None", "London"),
                new User("Bob", 41, "None", "London"),
                new User("Sam", 42, "None", "London"),
                new User("Anna", 41, "None", "London"),
                new User("Katya", 42, "None", "London"),
                new User("Vanya", 42, "None", "London"),
                new User("Kate", 41, "None", "London"),
                new User("George", 40, "None", "London")
        );

        Map<Integer, List<User>> ageSorted = User.groupUsers(userList);
        System.out.println(ageSorted);
    }
}
