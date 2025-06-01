package school.faang.bjs2_79146;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Евгений", 24, "OZON", "Москва"),
                new User("Анна", 25, "Яндекс", "Питер"),
                new User("Олег", 24, "SBER", "Казань"),
                new User("Денис", 23, "ItOne", "Омск"),
                new User("Максим", 23, "Alpha", "Самара")
        );

        Map<Integer, List<User>> grouped = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : grouped.entrySet()) {
            System.out.println("Возраст: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("  - " + user);
            }
        }
    }
}