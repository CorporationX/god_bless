package school.faang.BJS279141;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Anna", 25, new HashSet<>(Arrays.asList("reading", "swimming")));
        User user2 = new User(2, "Bob", 30, new HashSet<>(Arrays.asList("cycling", "chess")));
        User user3 = new User(3, "Clara", 22, new HashSet<>(Arrays.asList("reading", "gaming")));

        List<User> users = Arrays.asList(user1, user2, user3);
        HashSet<String> actionsToFind = new HashSet<>(Arrays.asList("reading", "gaming"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, actionsToFind);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
