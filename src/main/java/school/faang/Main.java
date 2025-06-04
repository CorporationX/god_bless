package school.faang;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(new User(1, "John", 25, new HashSet<>(Set.of("swim", "jumping"))),
                new User(2, "Sanni", 30, new HashSet<>(Set.of("rodeo", "running"))),
                new User(3, "Peter", 23, new HashSet<>(Set.of("sky diving", "photographing"))),
                new User(4, "Josh", 28, new HashSet<>(Set.of("sky diving", "ping pong"))),
                new User(5, "Hanna", 23, new HashSet<>(Set.of("tennis", "running"))));

        Set<String> hobbies = Set.of("ping pong", "sky diving");
        Map<User, String> userHobbiesMap = User.findHobbyLovers(users, hobbies);
        for (var userHobby : userHobbiesMap.entrySet()) {
            System.out.println(userHobby.getKey().getName() + ", " + userHobby.getValue());
        }
    }
}
