package school.faang.task_44010;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        var user1 = new User(1L, "Даниил", 21, new HashSet<>(Set.of("Чтение", "Программирование")));
        var user2 = new User(2L, "Денис", 16, new HashSet<>(Set.of("Спорт", "Кино")));
        var user3 = new User(3L, "Сергей", 22, new HashSet<>(Set.of("Волейбол", "Музыка")));
        users.add(user1);
        users.add(user2);
        users.add(user3);

        var hobbyLovers = User.findHobbyLovers(users, new HashSet<>(Set.of("Программирование", "Кино")));
        for (var test : hobbyLovers.entrySet()) {
            System.out.println(test.getKey().getName() + ": " + test.getValue());
        }
    }
}
