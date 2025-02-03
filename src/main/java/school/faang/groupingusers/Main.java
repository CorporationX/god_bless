package school.faang.groupingusers;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Aleksey", 25, "Google", "London"),
                new User("Mary", 30, "Yandex", "Moscow"),
                new User("Ivan", 25, "Facebook", "California"),
                new User("Olga", 30, "Amazon", "Washington")
        );

       Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("  " + user);
            }
        }
    }
}
