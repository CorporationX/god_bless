package school.faang.bjs2_85620;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(
                List.of(
                        new User("Kamil", 22, "Address1", "Work1"),
                        new User("Tair", 12, "Address1", "School"),
                        new User("Asya", 15, "Address1", "School"),
                        new User("Elena", 48, "Address1", "Work2"),
                        new User("Albert", 48, "Address1", "Work3")
                )
        );

        Map<Integer, List<User>> grouped = User.groupUsers(users);

        for (Integer age : grouped.keySet()) {
            System.out.printf("Age %d:%n", age);
            for (User user : grouped.get(age)) {
                System.out.printf(" - %s%n", user.getName());
            }
        }
    }
}