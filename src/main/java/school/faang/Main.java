package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user1 = new User("Vasya", 25, "IT", "Moscow");
        User user2 = new User("Sasha", 25, "Ozon", "Moscow");
        User user3 = new User("Petya", 27, "HR", "Moscow");
        User user4 = new User("Vladimir", 27, "Janitor", "Moscow");
        User user5 = new User("Kolya", 34, "IT", "Moscow");
        User user6 = new User("Ruslan", 21, "IT", "Moscow");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age " + entry.getKey() + ":");
            for (User user : entry.getValue()) {
                System.out.println("  " + user);
            }


        }
    }
}
