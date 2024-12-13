package school.faang.task_43777;

import java.util.List;

class UserFactory {
    protected static List<User> createUsers() {
        return List.of(
                new User("Alice", 25, "Google", "London"),
                new User("Bob", 30, "Amazon", "New York"),
                new User("Charlie", 22, "Uber", "Amsterdam"),
                new User("David", 28, "Google", "London"),
                new User("Eve", 35, "Amazon", "New York")
        );
    }
}