package faang.school.godbless;

import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Anton", 20, Set.of("Football", "Basketball")),
                new User(2, "Nikita", 11, Set.of("Fight")),
                new User(3, "Yarik", 60, Set.of("Run", "Basketball")),
                new User(4, "Anton", 20, Set.of("Draw", "Basketball")),
                new User(5, "Igor", 2, Set.of("Basketball")));

        Set<String> allHobbies = Set.of("Football", "Basketball", "Run", "Fight", "Draw");

        User user = new User();

        System.out.println(user.findHobbyLovers(users, allHobbies));

    }
}