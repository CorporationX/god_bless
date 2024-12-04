package school.faang.taskbjs243937;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Dima", 20, "Google", "London"));
        users.add(new User("Ivan", 44, "MTC", "MSK"));
        users.add(new User("Roman", 25, "Sber", "Rostov"));
        users.add(new User("Andrew", 53, "Avito", "London"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Возраст: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user);
            }
        }

    }
}
