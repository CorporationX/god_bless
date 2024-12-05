package school.faang.sprint1.task_43997;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Mike", 24, "Google", "Washington Boulevard, Los Angeles"));
        users.add(new User("Josh", 20, "Amazon", "Washington Boulevard, Los Angeles"));
        users.add(new User("Alice", 24, "X", "Trump street, Austin"));
        users.add(new User("Richard", 18, "Uber", "Martin Luther King Avenue, Dallas"));
        users.add(new User("Bob", 29, "Accenture", "Washington Boulevard, Los Angeles"));
        users.add(new User("Mike", 18, "Amazon", "Kennedy street, New York"));

        User.groupUsers(users).entrySet().forEach(System.out::println);
    }
}
