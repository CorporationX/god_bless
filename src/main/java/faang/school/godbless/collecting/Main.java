package faang.school.godbless.collecting;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1L, "Jake", 16, Set.of("hiking", "basketball", "gaming")),
                new User(2L, "Norman", 16, Set.of("piano", "gaming")),
                new User(3L, "Stanley", 16, Set.of("football", "electronics")),
                new User(4L, "Noah", 16, Set.of("books", "dancing")),
                new User(5L, "Bob", 16, Set.of("running", "lifting"))
        );

        User.findHobbyLovers(users, Set.of("hiking", "gaming", "lifting")).forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
