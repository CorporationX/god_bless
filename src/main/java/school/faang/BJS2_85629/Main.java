package school.faang.BJS2_85629;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Test:
        User user1 = new User("Петя", 22, "Google", "Деревня Чуваки");
        User user2 = new User("Маша", 35, "Google", "Деревня Чуваки");
        User user3 = new User("Дима", 22, "Google", "Деревня Чуваки");
        User user4 = new User("Люся", 18, "Google", "Деревня Чуваки");
        User user5 = new User("Глаша", 18, "Google", "Деревня Чуваки");
        User user6 = new User("Цицилия", 22, "Google", "Деревня Чуваки");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        Map<Integer, List<User>> result = User.groupUsers(users);
        result.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
