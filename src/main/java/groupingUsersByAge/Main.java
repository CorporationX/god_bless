package groupingUsersByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Denis", 22, "none", "Podolsk");
        User user2 = new User("Andrew", 32, "Metal", "Moscow");
        User user3 = new User("Karl", 33, "BMW", "Berlin");
        User user4 = new User("Lion", 33, "Apple", "Cupertino");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        Map<Integer, List<User>> map = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}