package faang.school.godbless.BJS2_4123;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(1, "Andrei", (byte) 22, new HashSet<>(List.of("a", "b", "c", "g", "e"))),
                new User(2, "Andrei", (byte) 22, new HashSet<>(List.of("a", "c", "e")))
        );

        System.out.println(User.findHobbyLovers(users, new HashSet<>(List.of("b", "c", "e"))));
    }
}
