package school.faang.bjs279238;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Ivan", 23, "BlastSmoke", "Smolna 51"),
                new User("Vova", 19, "BlastSmoke", "Smolna 51"),
                new User("Valera", 19, "Lethian", "Smolna 51"),
                new User("Kuba", 23, "Vizja", "Soltana 2"),
                new User("Jan", 26, "Akademia", "Okopowa 59")
        );

        System.out.println("Список пользователей: ");
        for (int i = 0; i < users.size(); i++) {
            System.out.printf("%d. %s%n", (i + 1), users.get(i));
        }

        Map<Integer, List<User>> groupedUsers = User.groupUser(users);
        System.out.println("\nГруппировка пользователей по возрасту: ");

        List<Integer> sortedAges = new ArrayList<>(groupedUsers.keySet());
        Collections.sort(sortedAges);

        for (Integer age : sortedAges) {
            List<User> usersOfAge = groupedUsers.get(age);
            System.out.printf("Возраст %d лет (%d человек):%n", age, usersOfAge.size());

            for (int i = 0; i < usersOfAge.size(); i++) {
                User user = usersOfAge.get(i);
                System.out.printf("%d. %s - %s (%s)%n",
                        (i + 1),
                        user.getName(),
                        user.getWorkplace(),
                        user.getAddress());
            }
        }
    }
}