package school.faang.firstStream.BJS2_31553;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(new User(1, "John", 25, Set.of("Fitness", "Football")),
                new User(2, "Mike", 32, Set.of("Basketball", "Fitness")),
                new User(3, "Antony", 19, Set.of("Tennis", "Fitness")));

        Set<String> activities = Set.of("Fitness", "Football", "Singing", "Running");

        Map<User, String> usersWithMatches = User.findHobbyLovers(users, activities);

        usersWithMatches.forEach((user, activity) -> System.out.println("User " + user.getName() + " : " + activity));
    }
}