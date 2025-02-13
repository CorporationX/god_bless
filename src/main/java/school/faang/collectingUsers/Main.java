package school.faang.collectingUsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user1 = new User(1, "Nick", 15, new HashSet<>(Arrays.asList("reading", "swimming")));
        User user2 = new User(2, "Nina", 20, new HashSet<>(Arrays.asList("running")));
        User user3 = new User(3, "Paul", 18, new HashSet<>(Arrays.asList("studying", "working")));

        users.add(user1);
        users.add(user2);
        users.add(user3);

        Set<String> hobbies = new HashSet<>(Arrays.asList("studying", "reading"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + " likes " + entry.getValue());
        }
    }
}
