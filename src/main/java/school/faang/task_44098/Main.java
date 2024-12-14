package school.faang.task_44098;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Alice", 25, Set.of("Reading", "Hiking")),
                new User("Bob", 30, Set.of("Cooking", "Cycling")),
                new User("Charlie", 22, Set.of("Reading", "Painting")),
                new User("David", 28, Set.of("Fishing", "Cooking"))
        );

        Set<String> hobbies = Set.of("Reading", "Hiking", "Cycling");
        Map<User, String> hobbyByUser = User.findHobbyLovers(users, hobbies);
        hobbyByUser.forEach((user, hobby) -> System.out.printf("%s loves %s\n", user.getName(), hobby));
    }
}
