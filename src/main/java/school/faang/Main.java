package school.faang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        User user1 = new User(1, "Анна", 25,
                Set.of("чтение", "плавание", "программирование"));

        User user2 = new User(2, "Иван", 30,
                Set.of("игры", "готовка", "бег"));

        User user3 = new User(3, "Мария", 28,
                Set.of("рисование", "танцы", "плавание"));

        User user4 = new User(4, "Петр", 35,
                Set.of("фотография", "путешествия"));

        List<User> users = List.of(user1, user2, user3, user4);

        Set<String> targetActivities = Set.of("плавание", "готовка", "походы", "танцы");

        Map<User, String> matchingUsers = User.findHobbyLovers(users, targetActivities);

        System.out.println("Пользователи с совпадающими активностями:");
        System.out.println("========================================");

        if (matchingUsers.isEmpty()) {
            System.out.println("Совпадений не найдено");
        } else {
            matchingUsers.forEach((user, activity) -> {
                System.out.printf("%s (возраст: %d) -> активность: '%s'%n",
                        user.getName(), user.getAge(), activity);
            });
        }

        System.out.println("========================================");
        System.out.printf("Всего пользователей: %d%n", users.size());
        System.out.printf("Найдено совпадений: %d%n", matchingUsers.size());
    }
}