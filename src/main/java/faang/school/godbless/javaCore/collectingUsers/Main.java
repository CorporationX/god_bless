package faang.school.godbless.javaCore.collectingUsers;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> hobbies = Set.of("football", "hockey", "swimming", "gaming");

        List<User> users = List.of(
                new User(1, "Петя", 23, Set.of("swimming","guitar","gaming")),
                new User(2, "Вася", 25, Set.of("hockey","gaming")),
                new User(3, "Катя", 33, Set.of("football","flowers"))
        );

        System.out.println(User.findHobbyLovers(users, hobbies));
    }
}
