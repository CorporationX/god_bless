package faang.school.godbless.BJS2_18440;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Alex", 21, Set.of("Fishing", "Running", "Hockey"));
        User user2 = new User(2, "Sergey", 32, Set.of("Hunting", "Fishing"));
        User user3 = new User(3, "Anna", 25, Set.of("Walking", "Running", "Cycling"));
        User user4 = new User(4, "Andrey", 23, Set.of("Running", "Hockey"));

        // Тестовые наборы
        // Set<String> activities = Set.of("Fishing", "Running", "Hockey", "Cycling");
        // Set<String> activities = Set.of("Cycling");
        // Set<String> activities = Set.of("Hunting");
        Set<String> activities = Set.of("Fishing", "Cycling");

        Map<User, String> foundUsers = User.findHobbyLovers(List.of(user1, user2, user3, user4), activities);
        System.out.println("Найденные пользователи: " + foundUsers);
    }
}
