package school.faang.task_BJS2_56452;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Map<Integer, List<String>> usersGroupedByAges = new HashMap<>();
        users.add(new User("Vlad", 30, "Sber", "Moscow"));
        users.add(new User("Bob", 31, "VK", "Novosibirk"));
        users.add(new User("Andrew", 30, "Yandex", "SPB"));
        users.add(new User("Olga", 31, "Mail", "Ekat"));
        usersGroupedByAges = User.groupUsers(users);
        for (Map.Entry<Integer, List<String>> entry : usersGroupedByAges.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}