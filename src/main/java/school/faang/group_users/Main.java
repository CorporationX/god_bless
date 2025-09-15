package school.faang.group_users;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("Vasya", 25, "IT", "Moscow");
        User user2 = new User("Sasha", 25, "Ozon", "Moscow");
        User user3 = new User("Petya", 27, "HR", "Moscow");
        User user4 = new User("Vladimir", 27, "Janitor", "Moscow");
        User user5 = new User("Kolya", 34, "IT", "Moscow");
        User user6 = new User("Ruslan", 21, "IT", "Moscow");

        List<User> users = List.of(user1, user2, user3, user4, user5, user6);


        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age " + entry.getKey() + ":");
            for (User user : entry.getValue()) {
                System.out.println("  " + user);
            }
        }
    }
}
