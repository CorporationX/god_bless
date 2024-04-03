package faang.school.godbless.BJS2_4123;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(1, "Andrei", 22, new HashSet<>(Set.of("a", "b", "c", "g", "e"))),
                new User(2, "Andrei", 22, new HashSet<>(Set.of("a", "c", "e")))
        );

        System.out.println(User.findHobbyLovers(users, new HashSet<>(Set.of("b", "c", "e"))));
    }
}
