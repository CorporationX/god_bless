package school.faang.task3;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Иван", 21, "СберБанк", "Пушкина дом Колотушкина"),
                new User("Егор", 18, "Яндекс", "г.Казань ул.Программистов д.010101")
        );

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age " + entry.getKey() + ":");
            for (User user : entry.getValue()) {
                System.out.println("  " + user.getName() + " - " + user.getJob());
            }
        }
    }
}
