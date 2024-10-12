package school.faang.collectingusers;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Create users with their activities
        User user1 = new User(1, "Alice", 25, Set.of("hiking", "reading", "coding"));
        User user2 = new User(2, "Bob", 30, Set.of("gaming", "coding", "cooking"));
        User user3 = new User(3, "Charlie", 22, Set.of("swimming", "reading", "traveling"));

        // List of users
        List<User> users = List.of(user1, user2, user3);

        // Set of hobbies we are interested in
        Set<String> hobbies = Set.of("reading", "coding");

        // Use the static method to find matching users
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);

        // Display the results
        hobbyLovers.forEach((user, hobby) ->
                System.out.println(user.getName() + " loves " + hobby)
        );
    }
}

