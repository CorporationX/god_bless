package school.faang.collectingusers;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Alice", 25, new HashSet<>(Set.of("hiking", "reading", "coding")));
        User user2 = new User(2, "Bob", 30, new HashSet<>(Set.of("gaming", "coding", "cooking")));
        User user3 = new User(3, "Charlie", 22, new HashSet<>(Set.of("swimming", "reading", "traveling")));

        List<User> users = List.of(user1, user2, user3);
        Set<String> hobbies = Set.of("reading", "coding");

        User exampleUser = new User();
        Map<User, String> hobbyLovers = exampleUser.findHobbyLovers(users, hobbies);

        hobbyLovers.forEach((user, hobby) ->
                System.out.println(user.getName() + " loves " + hobby)
        );
    }
}
