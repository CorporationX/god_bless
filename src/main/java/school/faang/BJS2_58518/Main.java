package school.faang.BJS2_58518;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Artur", 15, null, "ijrefijrife");
        User user2 = new User("Andrey", 15, null, "ijrefijrife");
        User user3 = new User("Leha", 15, null, "ijrefijrife");
        User user4 = new User("Misha", 17, null, "ijrefijrife");
        User user5 = new User("Katya", 15, null, "ijrefijrife");
        User user6 = new User("Artem", 16, null, "ijrefijrife");
        User user7 = new User("Artur", 20, null, "ijrefijrife");
        User user8 = new User("Fedya", 20, null, "ijrefijrife");
        User user9 = new User("Alice", 21, null, "ijrefijrife");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);
        printUsers(users);

    }

    public static void printUsers(List<User> users) {
        Map<Integer, List<User>> map = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

}
