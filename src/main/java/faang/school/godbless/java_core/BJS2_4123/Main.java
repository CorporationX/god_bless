package faang.school.godbless.java_core.BJS2_4123;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(1, "Ivan", 22, new HashSet<>(Set.of("a", "b", "c", "d", "e"))),
                new User(2, "Vladimir", 64, new HashSet<>(Set.of("e", "d", "z"))),
                new User(3, "Vlad", 36, new HashSet<>(Set.of("z", "k")))
        );

        System.out.println(User.findHobbyLovers(users, new HashSet<>(Set.of("z", "k"))));
    }
}
