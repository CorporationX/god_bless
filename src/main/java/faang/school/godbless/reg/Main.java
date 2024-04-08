package faang.school.godbless.reg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {

            List<User> userList = new ArrayList<>(Arrays.asList(
                    new User("Alice", 25, "Google", "London"),
                    new User("Bob", 30, "Amazon", "New York"),
                    new User("Charlie", 18, "Uber", "Amsterdam"),
                    new User("David", 40, "Google", "London"),
                    new User("Emma", 22, "Amazon", "Amsterdam"),
                    new User("Frank", 35, "Uber", "New York")
            ));

            System.out.println("All users:");
            userList.forEach(System.out::println);
            System.out.println();

            Map<Integer, List<User>> groupedUsers = User.groupUsers(userList);

            System.out.println("Grouped users:");
            groupedUsers.forEach((age, users) -> {
                System.out.println("Age: " + age);
                users.forEach(user -> System.out.println(user.getName()));
                System.out.println();
            });
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
