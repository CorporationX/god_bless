package school.faang.collectingusersbjs244018;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Alice", 25, new HashSet<>(Arrays.asList("reading", "swimming")));
        User user2 = new User(2, "Bob", 30, new HashSet<>(Arrays.asList("gaming", "running")));
        User user3 = new User(3, "Charlie", 22, new HashSet<>(Arrays.asList("reading", "gaming")));

        List<User> users = Arrays.asList(user1, user2, user3);
        Set<String> hobbies = new HashSet<>(Arrays.asList("reading", "cycling"));
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + " loves " + entry.getValue());
        }
    }
}

