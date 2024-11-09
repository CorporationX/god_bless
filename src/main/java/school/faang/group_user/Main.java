package school.faang.group_user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", 25, "Google", "California"));
        users.add(new User("Bob", 30, "Amazon", "Washington"));
        users.add(new User("Charlie", 25, "Facebook", "New York"));
        users.add(new User("Daisy", 35, "Apple", "California"));
        users.add(new User("Eve", 30, "Netflix", "Los Angeles"));

        // Группировка пользователей по возрасту
        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        // Вывод результата
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            int age = entry.getKey();
            List<User> usersWithSameAge = entry.getValue();
            System.out.println("Возраст: " + age);
            for (User user : usersWithSameAge) {
                System.out.println("  Имя: " + user.getName() + ", Работает в: " + user.getWorkplace() + ", Адрес: " + user.getAddress());
            }
            System.out.println();
        }
    }
}
