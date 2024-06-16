package collecting.users;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        User user1 = new User(1, Set.of("Коллекционирование", "Шитье"), 25, "Катя");
        User user2 = new User(2, Set.of("Бег", "Футбол"), 30, "Олег");
        User user3 = new User(3, Set.of("Велопрогулка", "Кулинария"), 43, "Роман");

        List<User> users = List.of(user1, user2, user3);
        Set<String> targetActivities = Set.of("Коллекционирование", "Шитье",
                "Бег", "Футбол", "Велопрогулка", "Кулинария");

        Main main = new Main();
        Map<User, List<String>> hobbyLovers = main.findHobbyLovers(users, targetActivities);

        for (Map.Entry<User, List<String>> entry : hobbyLovers.entrySet()) {
            System.out.println( "Пользователь: " + entry.getKey().name + ", Хобби: " + entry.getValue());
        }
    }

    public Map<User, List<String>> findHobbyLovers(List<User> users, Set<String> targetActivities) {
        Map<User, List<String>> result = new HashMap<>();

        for (User user : users) {
            for (String hobby : user.activities) {
                if (targetActivities.contains(hobby)) {
                    result.put(user, Collections.singletonList(hobby));
                    break;
                }
            }
        }

        return result;
    }
}