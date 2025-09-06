package school.faang;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User lily = new User("Lily", 35, "Vonage", "Tel Aviv");
        User daniel = new User("Daniel", 35, "Google", "Amsterdam");
        User alice = new User("Alice", 28, "Amazon", "Dublin");
        User bob = new User("Bob", 40, "Microsoft", "New York");
        User clara = new User("Clara", 28, "Intel", "Toronto");

        List<User> users = List.of(lily, daniel, alice, bob, clara);

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        groupedUsers.forEach((age, listOfUsersByAge) -> {
            System.out.println("Age " + age + ":");
            listOfUsersByAge.forEach(System.out::println);
        });

    }

}
