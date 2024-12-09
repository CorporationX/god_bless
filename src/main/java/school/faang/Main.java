package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Mira", 22, "Microsoft", "Dublin"));
        users.add(new User("Antonio", 27, "Meta", "Milan"));
        users.add(new User("Sofia", 30, "X", "Dublin"));
        users.add(new User("Bob", 22, "Google", "Paris"));
        users.add(new User("Laura", 30, "Sber", "Moscow"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        groupedUsers.forEach((age, list) -> {
            System.out.println("\nПользователи, которым " + age + " лет:");
            list.forEach(user -> System.out.println(user.toString()));
        });
    }
}
