package dima.evseenko.collecting;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user = new User(6L, "Alex", 20, Set.of("Games", "Guitar"));
        System.out.println(user.findHobbyLovers(getUsers()));
    }

    private static List<User> getUsers() {
        return Arrays.asList(
                new User(1L, "Dima", 22, Set.of("Guitar", "Football")),
                new User(2L, "Vasya", 21, Set.of("Swimming", "Basketball")),
                new User(3L, "Kolya", 20, Set.of("Running", "Flying")),
                new User(4L, "Sasha", 24, Set.of("Programming", "Football")),
                new User(5L, "Polina", 19, Set.of("Games", "Football"))
        );
    }
}
