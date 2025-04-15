package school.faang.bjs2_68096;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Задача "Коллекционируем пользователей"
 */
public class Main {
    public static void main(String[] args) {
        var users = List.of(
                new User(1, "Петя", 40, Set.of("3d printing", "fpv", "alcohol")),
                new User(2, "Дима", 39, Set.of("alcohol", "cars")),
                new User(3, "Серёжа", 39, Set.of()),
                new User(4, "Никита", 40, Set.of("cars", "bicycle"))
        );

        var alcoholics = User.findHobbyLovers(users, Set.of("alcohol"));
        var alcoholicsAndCyclist = User.findHobbyLovers(users, Set.of("alcohol", "bicycle"));

        System.out.printf("Алкоголики: %s%n", alcoholics);
        System.out.printf("Алкоголики и велосипедисты: %s%n", alcoholicsAndCyclist);
    }
}
