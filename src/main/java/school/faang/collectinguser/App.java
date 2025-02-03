package school.faang.collectinguser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        User maria = new User(1, "Maria", 28, new HashSet<>(Arrays.asList("reading", "swimming", "cycling")));
        User bob = new User(2, "Bob", 25, new HashSet<>(Arrays.asList("cycling", "running")));
        User stepan = new User(3, "Stepan", 23, new HashSet<>(Arrays.asList("hiking", "reading")));

        List<User> users = Arrays.asList(maria, bob, stepan);

        Set<String> targetActivities = new HashSet<>(Arrays.asList("reading", "cycling"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, targetActivities);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().toString() + " -> " + entry.getValue());
        }
    }
}
