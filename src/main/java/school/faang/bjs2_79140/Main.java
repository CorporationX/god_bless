package school.faang.bjs2_79140;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("John", 25, "Uber", "Izmailovskaya 5");
        User user2 = new User("Jane", 19, "Google", "Izmailovskaya 8");
        User user3 = new User("Alex", 30, "Yandex", "Leninskaya 2");
        User user4 = new User("Lucky", 30, "Google", "Mira 2");
        User user5 = new User("Bob", 19, "Netflix", "Leninskaya 1");

        List<User> users = List.of(user1, user2, user3, user4, user5);

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        System.out.println(groupedUsers);
    }
}
