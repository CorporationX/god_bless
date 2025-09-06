package school.faang.java_core.bjs2_85461;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static school.faang.java_core.bjs2_85461.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        // Создаем список пользователей
        List<User> users = new ArrayList<>();

        users.add(new User("John", 20, "Office 1", "address 1"));
        users.add(new User("Max", 25, "Office 2", "address 2"));
        users.add(new User("Ethan", 24, "Office 1", "address 3"));
        users.add(new User("Alice", 20, "Office 3", "address 4"));
        users.add(new User("Kim", 23, "Office 1", "address 5"));
        users.add(new User("Pit", 24, "Office 4", "address 6"));
        users.add(new User("Pit", 25, "Office 3", "address 7"));

        Map<Integer, List<User>> newUsers = groupUsers(users);

        // Выводим на экран
        for (Map.Entry<Integer, List<User>> entry : newUsers.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
