package faang.school.godbless.user;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Nick", 34, Set.of("Reading", "Gaming")),
                new User(2, "Ivan", 22, Set.of("Swimming", "Cooking")),
                new User(3, "Sergey", 45, Set.of("Hiking", "Traveling")),
                new User(4, "Oleg", 21, Set.of("Coding", "Running")),
                new User(5, "Andrei", 18, Set.of("Gaming", "Reading")),
                new User(6, "Maks", 28, Set.of("Swimming", "Hiking")),
                new User(7, "Ben", 22, Set.of("Coding", "Gaming")),
                new User(8, "Vlad", 33, Set.of("Reading", "Swimming")),
                new User(9, "Victor", 33, Set.of("Reading", "Hiking")),
                new User(10, "Vladimir", 40, Set.of("Gaming", "Coding"))
        );

        User.findHobbyLovers(users, Set.of("Gaming", "Coding"))
                .forEach((user, activity) -> System.out.println(user + " : " + activity));
    }
}
