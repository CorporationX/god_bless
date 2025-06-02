package school.faang.BJS2_79140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        User user1 = new User("John", 25, "Uber", "Izmailovskaya 5");
        User user2 = new User("Jane", 19, "Google", "Izmailovskaya 8");
        User user3 = new User("Alex", 30, "Yandex", "Leninskaya 2");
        User user4 = new User("Lucky", 30, "Google", "Mira 2");
        User user5 = new User("Bob", 19, "Netflix", "Leninskaya 1");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
    }

}
