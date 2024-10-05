package school.faang.BJS231573;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Andrey", 23, Set.of("Football", "Volleyball", "Tennis")));
        users.add(new User(2, "Vyacheslav", 51, Set.of("Running", "Tennis", "Fitness")));
        users.add(new User(3, "Benjamin", 44, Set.of("Basketball", "Chess")));
        users.add(new User(4, "John", 32, Set.of("Golf")));
        users.add(new User(5, "Abay", 36, Set.of("Table Tennis", "Chess")));

        System.out.println(User.findHobbyLovers(users, Set.of("Football", "Chess")));
    }
}
