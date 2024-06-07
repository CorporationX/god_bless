package faang.school.godbless.usercollection;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Alice", 25, new HashSet<>(List.of("reading", "swimming")));
        User user2 = new User(2, "Bob", 30, new HashSet<>(List.of("running", "swimming")));
        User user3 = new User(3, "Charlie", 22, new HashSet<>(List.of("cycling", "hiking")));

        List<User> users = List.of(user1, user2, user3);
        Set<String> activities = new HashSet<>(List.of("swimming", "cycling"));

        User exampleUser = new User(0, "Example", 0, Set.of());

        Map<User, String> hobbyLovers = exampleUser.findHobbyLovers(users, activities);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println("User: " + entry.getKey().getName() + ", Activity: " + entry.getValue());
        }
    }
}
