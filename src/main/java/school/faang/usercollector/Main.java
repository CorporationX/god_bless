package school.faang.usercollector;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<String> activity1 = Set.of("Борьба", "Футбол", "Плавание");
        Set<String> activity2 = Set.of("Чтение", "Йога", "Медитация", "Пилатес");
        Set<String> activity3 = Set.of("Ходьба", "Бег", "Прыжки в длину");

        User user1 = new User(1, "Иван", 18, activity3);
        User user2 = new User(2, "Сергей", 21, activity1);
        User user3 = new User(3, "Ольга", 20, activity2);

        List<User> users = Arrays.asList(user1, user2, user3);

        Set<String> activity = Set.of("Борьба", "Бег", "Медитация");

        Map<User, String> activLovers = User.findHobbyLovers(users, activity);

        for (Map.Entry<User, String> entry : activLovers.entrySet()) {
            System.out.printf("\n%s увлекается %s", entry.getKey().getName(), entry.getValue());
        }
    }
}