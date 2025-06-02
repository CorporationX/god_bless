package school.faang.bjs2_79177;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.bjs2_79177.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1L, "Steve", 20, Set.of("Футбол", "Теннис"));
        User user2 = new User(2L, "Nikita", 19, Set.of("Карате", "Матан", "Программирование"));
        User user3 = new User(3L, "Mike", 21, Set.of("Готовка", "Рисование"));

        Map<User, String> result = findHobbyLovers(List.of(user1, user2, user3),
                                                          Set.of("Карате", "Рисование"));
        System.out.println(result);
    }
}
