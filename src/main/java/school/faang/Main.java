package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Anton", 24, "Yandex", "Kazan"));
        users.add(new User("Alice", 26, "Google", "Prague"));
        users.add(new User("James", 24, "Amazon", "LA"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (var entry : groupedUsers.entrySet()) {
            System.out.println("Age " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
