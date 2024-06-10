package faang.school.godbless.user;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(List.of(
                new User("Nick", 18, "Google", "Amsterdam"),
                new User("Ivan", 25, "Google", "Amsterdam"),
                new User("Sergey", 25, "Google", "Amsterdam"),
                new User("Oleg", 18, "Google", "Amsterdam"),
                new User("Andrei", 25, "Google", "Amsterdam"),
                new User("Maks", 26, "Google", "Amsterdam"),
                new User("Ben", 26, "Google", "Amsterdam"),
                new User("Vlad", 18, "Google", "Amsterdam"),
                new User("Victor", 21, "Google", "Amsterdam"),
                new User("Vladimir", 25, "Google", "Amsterdam")
        ));

        User.groupUsers(users).forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
