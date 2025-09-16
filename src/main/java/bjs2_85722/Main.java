package bjs2_85722;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаем список пользователей
        List<User> users = new ArrayList<>();
        users.add(new User("Иван", 25, "Google", "Москва"));
        users.add(new User("Анна", 30, "Amazon", "СПб"));
        users.add(new User("Петр", 25, "Yandex", "Казань"));
        users.add(new User("Мария", 30, "Microsoft", "Алматы"));
        users.add(new User("Сергей", 40, "Tesla", "Нур-Султан"));

        // Группируем
        Map<Integer, List<User>> grouped = User.groupUsers(users);

        // Вывод результата
        for (Map.Entry<Integer, List<User>> entry : grouped.entrySet()) {
            System.out.println("Возраст " + entry.getKey() + ":");
            for (User u : entry.getValue()) {
                System.out.println("  " + u);
            }
        }
    }
}