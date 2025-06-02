package school.faang.BJS2_79167;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GroupAge {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("John", 30, "microsoft", "US"));
        users.add(new User("Mary", 25, "google", "Russia"));
        users.add(new User("Kevin", 23, "apple", "France"));
        users.add(new User("Nicholas", 24, "apple", "France"));

        Map<Integer, List<User>> groupUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry: groupUsers.entrySet()) {
            System.out.println("age " + entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}