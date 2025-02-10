package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Eva", 20, "Company A", "Address 1"),
                new User("David", 25, "Company B", "Address 2"),
                new User("Alex", 38, "Company C", "Address 3"),
                new User("Nick", 20, "Company D", "Address 4")
        );

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        StringBuilder output = new StringBuilder();

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            output.append("Age: ").append(entry.getKey()).append("\n");

            for (User user : entry.getValue()) {
                output.append(" ").append(user).append("\n");
            }
        }
        System.out.print(output);
    }
}
