package school.faang.bjs2_85502;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> usersList = List.of(
                new User(1, "Илья", 26, Set.of("a", "w", "z")),
                new User(2, "Виталя", 23, Set.of("q", "s")),
                new User(3, "Гриша", 24, Set.of("a", "gf", "g")),
                new User(4, "Ксюша", 23, Set.of("e", "a", "i")),
                new User(5, "Оля", 16, Set.of("s", "p", "j")),
                new User(6, "Витя", 43, Set.of("a", "v", "n")),
                new User(7, "Даша", 26, Set.of("e", "u", "v")),
                new User(8, "Алина", 19, Set.of("z", "f", "s"))
        );
        System.out.println(User.findHobbyLovers(usersList, Set.of("s", "q", "a")));
    }
}