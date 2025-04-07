package school.faang.collections;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Данила", 36, "ЦБ", "НН"),
                new User("Александр", 37, "Betting", "Питер"),
                new User("Алексей", 35, "ЦБ", "НН"),
                new User("Александр", 37, "Betting", "Питер"),
                new User("Егор", 36, "Yadro", "Москва"),
                new User("Света", 34, "РЖД", "Казань"),
                new User("Алла", 37, "Сбер", "НН")
        );

        User.groupUsers(users).forEach((age, userList) -> {
            System.out.printf("Возраст %d: \n", age);
            userList.forEach(user -> System.out.printf("  - %s\n", user.getName()));
        });
    }
}
