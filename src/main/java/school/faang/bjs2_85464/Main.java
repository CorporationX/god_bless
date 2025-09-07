package school.faang.bjs2_85464;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        User user1 = new User(1L, "Ruslan", 20, Set.of("чтение", "коньки", "гитара"));
        User user2 = new User(2L, "Artem", 22, Set.of("сноуборд", "плавание", "музыка"));
        User user3 = new User(3L, "Olga", 24, Set.of("пение", "йога", "путешествия"));
        User user4 = new User(4L, "Anna", 21, Set.of("бег", "спортзал", "мелодрамы"));
        User user5 = new User(5L, "Egor", 26, Set.of("футбол", "пайка", "нумизматика"));

        List<User> users = List.of(user1, user2, user3, user4, user5);

        Set<String> findActivities = Set.of("футбол", "сноуборд", "йога");
        Main main = new Main();
        Map<User, String> result = main.findHobbyLovers(users, findActivities);

        for (Map.Entry<User, String> e : result.entrySet()) {
            System.out.println(e.getKey().getName() + " " + "find activities: " + e.getValue());
        }

    }

    Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();

        if (users == null || activities == null) {
            return result;
        }

        for (User user : users) {
            user.getActivities().stream()
                    .filter(activities::contains)
                    .findFirst()
                    .ifPresent(activity -> result.put(user, activity));
        }
        return result;
    }
}