package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Eva", 20, "Company A", "Address 1"));
        users.add(new User("David", 25, "Company B", "Address 2"));
        users.add(new User("Alex", 38, "Company C", "Address 3"));
        users.add(new User("Nick", 20, "Company D", "Address 4"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user);
            }
        }
    }
}
