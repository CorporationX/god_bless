package school.faang.bjs2_85480;

import java.util.List;
import java.util.Map;
import java.util.Set;
import static school.faang.bjs2_85480.User.findHobbyLovers;

public class Main {

    public static void main(String[] args) {

        User user1 = new User(1, "Misha", 24, Set.of("gaming", "reading", "jogging"));
        User user2 = new User(2, "Natasha", 12, Set.of("reading", "coding", "hiking"));
        User user3 = new User(3, "Alena", 34, Set.of("coding", "hiking", "drawing"));
        User user4 = new User(4, "Maksim", 33, Set.of("gaming", "swimming", "jogging"));
        User user5 = new User(5, "Andrei", 21, Set.of("reading", "gaming", "swimming"));
        User user6 = new User(6, "Anya", 42, Set.of("gaming", "jogging", "swimming"));

        List<User> users = List.of(user1, user2, user3, user4, user5, user6);

        Set<String> fitness = Set.of("jogging", "hiking", "swimming");
        Map<User, String> hobbyLovers = findHobbyLovers(users, fitness);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey().getName(), entry.getValue());
        }
    }
}