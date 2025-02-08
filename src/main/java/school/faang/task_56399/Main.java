package school.faang.task_56399;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.task_56399.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {

        User testUser1 = new User(0, "Андрей", 25, Set.of("бег", "плавание", "ходьба"));
        User testUser2 = new User(1, "Александр", 45, Set.of("прыжки", "приседания"));
        User testUser3 = new User(2, "Сергей", 23, Set.of("плавание", "бег"));

        List<User> testUsersList = List.of(testUser1, testUser2, testUser3);
        Set<String> testActivities = Set.of("стрельба", "прыжки", "ходьба");

        Map<User, String> testMap = findHobbyLovers(testUsersList, testActivities);

        for (Map.Entry<User, String> entry : testMap.entrySet()) {
            System.out.println(entry.getKey() + " Сопавшая активность: " + entry.getValue());
        }
    }
}