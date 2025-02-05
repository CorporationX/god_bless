package school.faang.sprint.first.collectingusers;

import school.faang.sprint.first.collectingusers.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(
                new User("Петя", 1, 2, new HashSet<>(List.of("Танцы", "Дота", "Реарм"))),
                new User("Вася", 2, 22, new HashSet<>(List.of("Книги", "Пение", "КС ГО", "Дота"))),
                new User("Даша", 3, 12, new HashSet<>(List.of("Вязание", "Гадание"))),
                new User("Гога", 4, 27, new HashSet<>(List.of("Пение", "Голодные игры"))),
                new User("Иван", 5, 28, new HashSet<>(List.of("Огород", "Машины")))
        );

        User.findHobbyLovers(userList, Set.of("Дота", "Пение"));
    }
}
