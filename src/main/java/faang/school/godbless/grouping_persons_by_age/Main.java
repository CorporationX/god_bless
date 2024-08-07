package faang.school.godbless.grouping_persons_by_age;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Alex", 28, "WB", "Kazan"),
                new User("Alexandr", 28, "Uber", "Amsterdam"),
                new User("Anna", 30, "Amazon", "New York"),
                new User("Anastasia", 38, "Google", "Amsterdam"),
                new User("Ethna", 17, "Microsoft", "Chicago")
        );

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            List<User> usersByAge = entry.getValue();
            for (User user : usersByAge) {
                System.out.println(user);
            }
        }
    }
}