package faang.school.godbless.user;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Nick", 16, "Google", "Berlin"),
                new User("Ivan", 25, "Google", "Berlin"),
                new User("Sergey", 25, "Google", "Berlin"),
                new User("Oleg", 16, "Google", "Berlin"),
                new User("Andrei", 25, "Google", "Berlin"),
                new User("Maks", 26, "Google", "Berlin"),
                new User("Ben", 26, "Google", "Berlin"),
                new User("Vlad", 16, "Google", "Berlin"),
                new User("Victor", 21, "Google", "Berlin"),
                new User("Vladimir", 25, "Google", "Berlin")
        );

        User.groupUsers(users).forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
