package school.faang.collectionusers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Alice", 25, new HashSet<>(Arrays.asList("reading", "swimming", "cycling")));
        User user2 = new User(2, "Nik", 35, new HashSet<>(Arrays.asList("hiking", "photography")));
        User user3 = new User(3, "Alex", 38, new HashSet<>(Arrays.asList("gaming", "coding", "reading")));

        List<User> users = Arrays.asList(user1, user2, user3);
        Set<String> hobbies = new HashSet<>(Arrays.asList("hiking", "swimming"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println("User: " + entry.getKey() + ", First Matching Activity: " + entry.getValue());
        }
    }
}
