package school.faang.task_56377;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Alice", 30, "Hospital", "Oak Avenue"),
                new User("Bob", 28, "IT Company", "Maple Street"),
                new User("Fred", 45, "School", "Elm street"),
                new User("Charlie", 35, "University", "Pine Road"),
                new User("David", 45, "Bank", "Cedar Lane"),
                new User("Eve", 30, "Startup", "Birch Boulevard")
        );

        Map<Integer, List<User>> usersByAge = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : usersByAge.entrySet()) {
            System.out.println("These users are " + entry.getKey() + " years old: " + entry.getValue());
        }

    }
}
