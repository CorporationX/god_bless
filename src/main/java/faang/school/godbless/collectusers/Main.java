package faang.school.godbless.collectusers;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Петр", 15, Set.of("Плавание", "Танцы", "Гейминг")),
                new User(2, "Вадим", 24, Set.of("Йога", "Ходьба", "Фотография")),
                new User(3, "Андрей", 22, Set.of("Оригами", "Рисование", "Тир"))
        );

        Set<String> activities = Set.of("Танцы", "Фотография", "Оригами");

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
    }
}