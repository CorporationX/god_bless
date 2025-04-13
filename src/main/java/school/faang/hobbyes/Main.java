package school.faang.hobbyes;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Andrew", 20, Set.of("tv", "sport", "eat"), 1),
                new User("Kirill", 21, Set.of("youtube", "circling", "games"), 2),
                new User("Nikita", 23, Set.of("swim", "sport", "car"), 3),
                new User("Dima", 24, Set.of("golf"), 4),
                new User("Natan", 26, Set.of("Tennis"), 5)
        );
        Map<User, String> result = User.findHobbyLovers(users, Set.of("eat", "sport", "games"));
        System.out.println(result);
    }
}