package school.faang.collcetUsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Alice", 30, new HashSet<>(Arrays.asList("Reading", "Swimming")));
        User user2 = new User(2, "Bob", 25, new HashSet<>(Arrays.asList("Running", "Cycling")));
        User user3 = new User(3, "Charlie", 28, new HashSet<>(Arrays.asList("Swimming", "Cooking")));

        List<User> users = List.of(user1, user2, user3);
        Set<String> hobbies = new HashSet<>(Arrays.asList("Swimming", "Dancing"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);

        // Вывод результата
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + " "+ entry.getValue());
        }
    }
}