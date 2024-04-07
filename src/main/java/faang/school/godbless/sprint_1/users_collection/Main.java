package faang.school.godbless.sprint_1.users_collection;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<User> users = List.of(
                new User(1L, "Test1", 18, Set.of("football", "basketball")),
                new User(2L, "Test2", 18, Set.of("volleyball", "basketball")),
                new User(3L, "Test3", 18, Set.of("golf"))
        );

        User.findHobbyLovers(users, Set.of("football")).forEach(((user, s) -> System.out.printf("%s -> %s%n", user, s)));
        System.out.println();
        User.findHobbyLovers(users, Set.of("volleyball", "golf")).forEach(((user, s) -> System.out.printf("%s -> %s%n", user, s)));
    }

}
