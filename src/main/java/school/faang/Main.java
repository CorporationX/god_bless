package school.faang;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Vasya", 28, "Yandex", "Moscow"),
                new User("Petya", 35, "Google", "Berlin"),
                new User("Alina", 28, "VK", "Saint-Petersburg"),
                new User("Nikolai", 23, "Netflix", "London")
        );

        Map<Integer, List<User>> result = User.groupUsers(users);

        System.out.println(result);
    }
}
