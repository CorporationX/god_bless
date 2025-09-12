package bjs2_85722;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаем список пользователей
        List<User> users = new ArrayList<>();
        users.add(new User("Билл", 25, "Google", "Новосиб"));
        users.add(new User("Чак", 30, "Amazon", "Томск"));
        users.add(new User("Сергей", 25, "Yandex", "Джамбул"));
        users.add(new User("Сингх", 30, "Microsoft", "Алматы"));
        users.add(new User("Мугамба", 40, "Tesla", "Из дому"));

        // Группировка
        Map<Integer, List<User>> grouped = User.groupUsers(users);

        // Вывод результата
        for (Map.Entry<Integer, List<User>> entry : grouped.entrySet()) {
            System.out.println("Возраст " + entry.getKey() + ":");
            for (User u : entry.getValue()) {
                System.out.println("  " + u.getName() + " (" + u.getWorkplace() + ", " + u.getAddress() + ")");
            }
        }
    }
}