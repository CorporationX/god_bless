package school.faang.bjs2_86444;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Alexey", 20, Set.of("Football", "Gaming", "Coding"));
        User user2 = new User(2, "Anna", 22, Set.of("Reading", "Traveling", "Gaming"));
        User user3 = new User(3, "Ivan", 25, Set.of("Cooking", "Chess"));

        List<User> users = List.of(user1, user2, user3);
        Set<String> hobbiesToFind = Set.of("Gaming", "Cooking");

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbiesToFind);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.printf("%s увлекается: %s%n", entry.getKey().getName(), entry.getValue());
        }
    }
}
