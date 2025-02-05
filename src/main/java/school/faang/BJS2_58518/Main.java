package school.faang.BJS2_58518;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        printUsers(User.groupUsers(createUsers()));
    }

    public static List<User> createUsers() {
        User user1 = new User("Artur", 15, null, "ijrefijrife");
        User user2 = new User("Andrey", 15, null, "ijrefijrife");
        User user3 = new User("Leha", 15, null, "ijrefijrife");
        User user4 = new User("Misha", 17, null, "ijrefijrife");
        User user5 = new User("Katya", 15, null, "ijrefijrife");
        User user6 = new User("Artem", 16, null, "ijrefijrife");
        User user7 = new User("Artur", 20, null, "ijrefijrife");
        User user8 = new User("Fedya", 20, null, "ijrefijrife");
        User user9 = new User("Alice", 21, null, "ijrefijrife");

        List<User> users = List.of(user1, user2, user3, user4, user5, user6, user7, user8, user9);
        return users;
    }

    public static void printUsers(Map<Integer, List<User>> map) {
        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
