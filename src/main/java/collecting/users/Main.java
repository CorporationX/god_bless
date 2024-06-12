package collecting.users;

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
        Map<String, User> hobbyLovers = main.findHobbyLovers(users, targetActivities);

        for (Map.Entry<String, User> entry : hobbyLovers.entrySet()) {
            System.out.println("Хобби: " + entry.getKey() + ", Пользователь: " + entry.getValue().name);
        }
    }

    public Map<String, User> findHobbyLovers(List<User> users, Set<String> targetActivities) {
        Map<String, User> result = new HashMap<>();

        for (User user : users) {
            for (String hobby : user.activities) {
                if (targetActivities.contains(hobby)) {
                    result.put(hobby, user);
                    break;
                }
            }
        }

        return result;
    }


}