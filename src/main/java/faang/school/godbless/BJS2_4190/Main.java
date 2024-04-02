package faang.school.godbless.BJS2_4190;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> usersForExample = new ArrayList<>(
                List.of(
                        new User("Tom", 22, "Apple", "California"),
                        new User("Dray", 23, "Office", "Las-vegas"),
                        new User("Polly", 22, "Bank of America", "New York"),
                        new User("Gray", 27, "New York Times", "New York")
                ));

        Map<Integer, List<User>> users = User.groupUsers(usersForExample);
        for (var entry : users.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("Name: " + user.getName());
            }
        }
    }
}
