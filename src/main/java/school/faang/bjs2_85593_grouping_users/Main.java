package school.faang.bjs2_85593_grouping_users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Anton", 21);
        User user2 = new User("Jan", 18);
        User user3 = new User("Olga", 22);
        User user4 = new User("Goga", 21);
        User user5 = new User("Igor", 19);
        User user6 = new User("Masha", 22);
        User user7 = new User("Alex", 18);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Возраст: " + entry.getKey());
            List<User> userInGroupe = entry.getValue();

            for (User user : userInGroupe) {
                System.out.println(" - " + user.getName());
            }
        }
    }
}
