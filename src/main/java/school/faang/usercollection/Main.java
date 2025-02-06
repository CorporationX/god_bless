package school.faang.usercollection;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

    public static void main(String[] args) {
        List<User> users = List.of(
                new User(ID_GENERATOR.incrementAndGet(), "Kolya", 20, Set.of("Футбол", "Баскетбол")),
                new User(ID_GENERATOR.incrementAndGet(), "Vasya", 20, Set.of("Футбол", "Тенис")),
                new User(ID_GENERATOR.incrementAndGet(), "Petya", 25, Set.of("Бокс", "Борьба")),
                new User(ID_GENERATOR.incrementAndGet(), "Elon", 30, Set.of("Чтение", "Плавание")),
                new User(ID_GENERATOR.incrementAndGet(), "Alex", 40, Set.of("Программирование", "Шахматы"))
        );
        Set<String> activities = Set.of("Футбол", "Волейбол", "Музыка", "Программирование");

        Map<User, String> groupedUsers = User.findHobbyLovers(users, activities);
        for (var entry : groupedUsers.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
