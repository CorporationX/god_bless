package school.faang;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        User user1 = new User(1, "Анна", 25,
                new HashSet<>(Arrays.asList("чтение", "плавание", "программирование")));

        User user2 = new User(2, "Иван", 30,
                new HashSet<>(Arrays.asList("игры", "готовка", "бег")));

        User user3 = new User(3, "Мария", 28,
                new HashSet<>(Arrays.asList("рисование", "танцы", "плавание")));

        User user4 = new User(4, "Петр", 35,
                new HashSet<>(Arrays.asList("фотография", "путешествия")));

        List<User> users = Arrays.asList(user1, user2, user3, user4);

        Set<String> targetActivities = new HashSet<>(Arrays.asList(
                "плавание", "готовка", "походы", "танцы"
        ));

        // Вызываем метод для поиска совпадений
        Map<User, String> matchingUsers = User.findHobbyLovers(users, targetActivities);

        // Выводим результаты
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

        // Дополнительная статистика
        System.out.println("========================================");
        System.out.printf("Всего пользователей: %d%n", users.size());
        System.out.printf("Найдено совпадений: %d%n", matchingUsers.size());
    }
}