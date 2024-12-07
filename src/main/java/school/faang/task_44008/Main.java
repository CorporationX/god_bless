package school.faang.task_44008;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        var activities = Set.of("Баскетбол", "Футбол", "Книги", "Музыка", "Готовка");
        var users = List.of(
            new User(1, "user1", 18, Set.of("Лепка", "Книги")),
            new User(2, "user2", 32, Set.of("Прогулки", "Футбол", "Музыка")),
            new User(3, "user3", 23, Set.of("Искусство", "Архитектура"))
        );

        System.out.println(User.findHobbyLovers(users, activities));
    }
}
