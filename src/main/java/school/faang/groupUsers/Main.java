package school.faang.groupUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user = new User("John", 25, "Software Engineer", "123 Main St");
        User user2 = new User("Jane", 30, "Product Manager", "456 Elm St");
        User user3 = new User("Bob", 40, "Data Scientist", "789 Oak St");
        User user4 = new User("Alice", 35, "UX Designer", "321 Pine St");

        Map<Integer, List<User>> grouped = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
