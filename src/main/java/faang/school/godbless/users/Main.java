package faang.school.godbless.users;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Ivan", 25, Set.of("Yoga", "Swimming", "Boxing")),
                new User(2, "Bob", 30, Set.of("Swimming", "Running")),
                new User(3, "Anna", 26, Set.of("Swimming", "Yoga")),
                new User(4, "David", 25, Set.of("Boxing", "Football")),
                new User(5, "Lora", 32, Set.of("Swimming", "Yoga"))
        );

        System.out.println(User.findHobbyLovers(users, Set.of("Swimming", "Yoga")));
    }
}
