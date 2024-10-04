package school.faang.collecting.users;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1L, "Коля", 21, Set.of("спорт зал", "программирование", "прогулки"));
        User user2 = new User(1L, "Никита", 21, Set.of("футбол", "программирование", "теннис"));
        User user3 = new User(1L, "Костя", 21, Set.of("прогулки", "спорт зал", "просмотр фильмов"));
        User user4 = new User(1L, "Аноним", 21, Set.of("бухать в подъзде"));
        List<User> users = List.of(user2, user3, user4);

        Map<User, String> userToActivity = user1.findHobbyLovers(users, user1.getActivities());
        userToActivity.forEach((key, value) -> System.out.println(key.getName() + ": " + value));
    }
}
