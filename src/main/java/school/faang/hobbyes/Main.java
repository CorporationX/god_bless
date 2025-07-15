package school.faang.hobbyes;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Andrew", 20, Set.of("tv", "sport", "eat")),
                new User(2, "Kirill", 22, Set.of("youtube", "circling", "games")),
                new User(3, "Nikita", 23, Set.of("swim", "sport", "car")),
                new User(4, "Dima", 25, Set.of("golf")),
                new User(5, "Natan", 24, Set.of("Tennis"))
        );
        Map<User, String> result = User.findHobbyLovers(users, Set.of("eat", "sport", "games"));
        System.out.println(result);
    }
}