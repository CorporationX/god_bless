package school.faang.BJS2_68100;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Nick", 22, "T", "Tralala str, 23"),
                new User("Sam", 23, "VTB", "Tralala str, 23"),
                new User("Frodo", 22, "SBER", "Tralala str, 24"),
                new User("Fulgrim", 24, "T", "Tralala str, 24"),
                new User("Angron", 24, "T", "Tralala str, 25"),
                new User("Perturabo", 25, "SBER", "Tralala str, 25"),
                new User("Fedya", 25, "VTB", "Tralala str, 26"),
                new User("Felix", 22, "Alpha", "Tralala str, 26")
        );

        System.out.println(User.groupUsers(users));
    }
}
