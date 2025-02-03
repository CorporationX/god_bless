package school.faang.collectionusers;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Alice", 25, new HashSet<>(List.of("reading", "swimming", "cycling")));
        User user2 = new User(2, "Nik", 35, new HashSet<>(List.of("hiking", "photography")));
        User user3 = new User(3, "Alex", 38, new HashSet<>(List.of("gaming", "coding", "reading")));

        List<User> users = List.of(user1, user2, user3);
        Set<String> hobbies = new HashSet<>(List.of("hiking", "swimming"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println("User: " + entry.getKey() + ", First Matching Activity: " + entry.getValue());
        }
    }
}
