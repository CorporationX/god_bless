package school.faang.grouping_users_by_age;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Аня", 25, "Google", "Москва"),
                new User("Иван", 30, "Яндекс", "Санкт-Петербург"),
                new User("Ольга", 25, "Mail.ru", "Казань"),
                new User("Петр", 30, "Сбербанк", "Новосибирск"),
                new User("Саша", 22, "Тинькофф", "Екатеринбург")
        );
        Map<Integer, List<User>> grouped = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : grouped.entrySet()) {
            System.out.println("Возраст: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("  " + user);
            }
        }
    }
}