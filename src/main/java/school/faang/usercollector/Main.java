package school.faang.usercollector;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        HashSet<String> activity1 = new HashSet<>(Arrays.asList("Борьба", "Футбол", "Плавание"));
        HashSet<String> activity2 = new HashSet<>(Arrays.asList("Чтение", "Йога", "Медитация", "Пилатес"));
        HashSet<String> activity3 = new HashSet<>(Arrays.asList("Ходьба", "Бег", "Прыжки в длину"));

        User user1 = new User(1, "Иван", 18, activity3);
        User user2 = new User(2, "Сергей", 21, activity1);
        User user3 = new User(3, "Ольга", 20, activity2);

        List<User> users = Arrays.asList(user1, user2, user3);

        Set<String> activity = new HashSet<>(Arrays.asList("Борьба", "Бег", "Медитация"));

        Map<User, String> activLovers = User.findHobbyLovers(users, activity);

        for (Map.Entry<User, String> entry : activLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + " увлекается " + entry.getValue());
        }
    }
}