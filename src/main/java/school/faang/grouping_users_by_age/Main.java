package school.faang.grouping_users_by_age;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Alice", 25, "Google", "123 Maple St"),
                new User("Bob", 35, "Amazon", "456 Oak St"),
                new User("Charlie", 28, "Microsoft", "789 Pine St"),
                new User("David", 35, "Apple", "321 Elm St"),
                new User("Eve", 45, "Meta", "654 Cedar St"),
                new User("Frank", 28, "Netflix", "987 Birch St"),
                new User("Grace", 25, "Adobe", "159 Walnut St"),
                new User("Hank", 33, "Tesla", "753 Chestnut St"),
                new User("Ivy", 25, "IBM", "951 Redwood St"),
                new User("Jack", 45, "Intel", "852 Spruce St")
        );

        for (Map.Entry<Integer, List<User>> entry : User.groupUsers(users).entrySet()) {
            System.out.println(String.format("Возрастная категория %d:\n\tСписок студентов(%s)",
                    entry.getKey(), entry.getValue()));
        }

    }
}