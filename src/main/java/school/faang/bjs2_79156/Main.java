package school.faang.bjs2_79156;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> usersCompare = List.of(new User(1, "Ахилес", 18, Set.of("Бег", "Пробежка", "Драка")),
                new User(2, "Архимед", 44, Set.of("Бег", "Качалка", "Спиритизм")),
                new User(3, "Архимонд", 328, Set.of("Аниматор")));
        Set<String> activitiesCompare = Set.of("Качалка", "Бег");

        Map<User, String> users = User.findHobbyLovers(usersCompare, activitiesCompare);
        System.out.println(users);
    }
}