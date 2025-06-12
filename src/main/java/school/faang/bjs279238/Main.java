package school.faang.bjs279238;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Ivan", 23, "BlastSmoke", "Smolna 51"));
        users.add(new User("Vova", 19, "BlastSmoke", "Smolna 51"));
        users.add(new User("Valera", 19, "Lethian", "Smolna 51"));
        users.add(new User("Kuba", 23, "Vizja", "Soltana 2"));
        users.add(new User("Jan", 26, "Akademia", "Okopowa 59"));

        System.out.println("Список пользователей: ");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i));
        }

        Map<Integer, List<User>> groupedUsers = User.groupUser(users);
        System.out.println("\nГруппировка пользователей по возрасту: ");

        List<Integer> sortedAges = new ArrayList<>(groupedUsers.keySet());
        Collections.sort(sortedAges);

        for (Integer age : sortedAges) {
            List<User> usersOfAge = groupedUsers.get(age);
            System.out.println("Возраст " + age + " лет (" + usersOfAge.size() + " человек):");

            for (int i = 0; i < usersOfAge.size(); i++) {
                User user = usersOfAge.get(i);
                System.out.println((i + 1) + ". " + user.getName() + " - " + user.getWorkplace() + " (" + user.getAddress() + ")");
            }
        }
    }
}