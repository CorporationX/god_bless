package school.faang.BJS2_79156;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Ахилес", 18, Set.of("Бег", "Пробежка", "Драка"));
        User user2 = new User(2, "Архимед", 44, Set.of("Бег", "Качалка", "Спиритизм"));
        User user3 = new User(3, "Архимонд", 328, Set.of("Аниматор"));

        List<User> usersCompare = List.of(user1, user2, user3);

        Set<String> activitiesCompare = Set.of("Качалка", "Бег");

        Map<User, String> users = User.findHobbyLovers(usersCompare, activitiesCompare);
        System.out.println(users);



    }
}