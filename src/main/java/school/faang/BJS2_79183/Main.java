package school.faang.BJS2_79183;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Иван", 30, "Google", "Москва"));
        userList.add(new User("Анна", 25, "Yandex", "Санкт-Петербург"));
        userList.add(new User("Петр", 30, "Microsoft", "Новосибирск"));
        userList.add(new User("Елена", 35, "Amazon", "Казань"));
        userList.add(new User("Дмитрий", 25, "Facebook", "Екатеринбург"));
        userList.add(new User("Ольга", 30, "Apple", "Краснодар"));
        userList.add(new User("Сергей", 40, "IBM", "Нижний Новгород"));

        System.out.println("Исходный список пользователей:");
        for (User user : userList) {
            System.out.println(user);
        }
        System.out.println("\n--- Группировка пользователей по возрасту ---\n");

        Map<Integer, List<User>> groupedByAge = User.groupUsers(userList);

        for (Map.Entry<Integer, List<User>> entry : groupedByAge.entrySet()) {
            Integer age = entry.getKey();
            List<User> usersOfSameAge = entry.getValue();
            System.out.println("Возраст: " + age + " лет");
            for (User user : usersOfSameAge) {
                System.out.println("  - " + user.getName() + " (" + user.getWorkplace() + ")");
            }
            System.out.println();
        }
    }
}