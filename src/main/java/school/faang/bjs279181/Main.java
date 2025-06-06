package school.faang.bjs279181;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> userList;
        userList = List.of(
                new User(0, "Dima", 21, Set.of("Воркаут", "Програмирование", "Игра на гитаре")),
                new User(1, "Vlad", 28, Set.of("Казино", "Литр Болл", "Чтение")),
                new User(2, "Kola", 24, Set.of("Воркаут", "Готовка", "Чтение"))
        );

        Set<String> actions;
        actions = Set.of("Чтение", "Литр Болл", "Готовка", "Воркаут");
        Map<User, String> userAction = new HashMap<>();
        userAction = User.findHobbyLovers(userList, actions);

        userAction.forEach((user, action) -> {
            System.out.println(user.getName() + " " + action);
        });
    }
}
