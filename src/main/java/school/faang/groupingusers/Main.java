package school.faang.groupingusers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String AGE_FORMAT = "Age %d:\n";
    private static final String NAME_FORMAT = "Name: %s, ";
    private static final String WORKPLACE_FORMAT = "workplace: %s, ";
    private static final String ADDRESS_FORMAT = "address: %s\n";

    public static void main(String[] args) {
        try {
            List<User> users = new ArrayList<>();

            users.add(new User("Maxim", 26, "Google", "Wall street"));
            users.add(new User("Alex", 27, "Microsoft", "Wall street"));
            users.add(new User("Sergey", 23, "Google", "Wall street"));
            users.add(new User("Nick", 23, "Microsoft", "Empire street"));
            users.add(new User("Anton", 27, "Microsoft", "Empire street"));
            users.add(new User("Valera", 27, "Google", "Empire street"));

            Map<Integer, List<User>> usersByAge = new HashMap<>(User.groupUsers(users));

            usersByAge.forEach((key, value) -> {
                System.out.printf(AGE_FORMAT, key);
                value.forEach(user -> {
                    System.out.printf(NAME_FORMAT, user.getName());
                    System.out.printf(WORKPLACE_FORMAT, user.getWorkplace());
                    System.out.printf(ADDRESS_FORMAT, user.getAddress());
                });
            });
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
