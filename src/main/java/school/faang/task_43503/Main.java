package school.faang.task_43503;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Tom", 25, "Corp 1", "Adress A"),
                new User("Sofia", 18, "Corp 2", "Adress B"),
                new User("Bob", 36, "Corp 3", "Adress C"),
                new User("Jerry", 52, "Corp 4", "Adress D")
        );

        for (Map.Entry<Integer, List<User>> usersEntry : User.groupUsers(users).entrySet()) {
            System.out.println(usersEntry);
        }
    }
}
