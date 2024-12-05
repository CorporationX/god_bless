package school.faang.task_44004;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<User> users = List.of(
                new User(1, "User1", 21, Set.of("a", "b", "c")),
                new User(2, "User2", 22, Set.of("a", "b", "d")),
                new User(3, "User3", 23, Set.of("a", "c", "d")),
                new User(4, "User4", 24, Set.of("b", "c", "d")),
                new User(5, "User5", 25, Set.of("a", "d")),
                new User(5, "User6", 25, Set.of("c", "d"))
        );


        Set<String> hobbies = Set.of("b", "c");

        User.findHobbyLovers(users, hobbies).forEach(
                (user, hobby) -> System.out.printf("%s\n%s -> %s\n\n", hobbies, user, hobby)
        );
    }

}
