package school.faang.task_BJS2_56323;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static final Set<String> HOBBIES = new HashSet<>(List.of("Swimming", "Running"));

    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Anton", 10, java.util.Set.of("Swimming", "Book reading")),
                new User(2, "Anna", 20, java.util.Set.of("Running", "Book listening")),
                new User(2, "Oleg", 30, java.util.Set.of("Fitness", "TV watching"))
        );
        Map<String, String> hobbyLovers = User.findHobbyLovers(users, HOBBIES);
        for (Map.Entry<String, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
