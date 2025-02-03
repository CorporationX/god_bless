package school.faang.groupingusers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Maxim", 26, "Google", "Wall street"));
        users.add(new User("Alex", 27, "Microsoft", "Wall street"));
        users.add(new User("Sergey", 23, "Google", "Wall street"));
        users.add(new User("Nick", 23, "Microsoft", "Empire street"));
        users.add(new User("Anton", 27, "Microsoft", "Empire street"));
        users.add(new User("Valera", 27, "Google", "Empire street"));

        Map<Integer, List<User>> usersByAge = new HashMap<>(User.groupUsers(users));

        for (Map.Entry<Integer, List<User>> iteratingUsersByAge : usersByAge.entrySet()) {
            System.out.printf("Age %d:\n", iteratingUsersByAge.getKey());

            for (User user : iteratingUsersByAge.getValue()) {
                System.out.printf("Name: %s, ", user.getName());
                System.out.printf("workplace: %s, ", user.getWorkplace());
                System.out.printf("address: %s\n", user.getAddress());
            }
        }
    }
}
