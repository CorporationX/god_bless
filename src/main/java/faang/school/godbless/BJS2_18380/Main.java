package faang.school.godbless.BJS2_18380;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1L, "Vladimir", 14, Set.of("Drawing", "Reading", "Volleyball")),
                new User(2L, "Denis", 17, Set.of("Snowboarding", "Photography", "Baseball")),
                new User(3L, "Dmitriy", 23, Set.of("Climbing", "Clubbing", "Reading"))
        );

        Set<String> activities = Set.of("Volleyball", "Snowboarding", "Clubbing");

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
    }
}